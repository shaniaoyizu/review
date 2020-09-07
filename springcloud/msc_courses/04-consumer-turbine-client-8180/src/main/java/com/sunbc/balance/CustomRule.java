package com.sunbc.balance;

/**
 * Created on 2020-09-04
 *
 * @author sunbc
 * @Describe
 * @since
 */

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 从所有可用的provider中排除掉指定端口号的provider，剩余provider进行随机选择
 */
public class CustomRule implements IRule {

    private ILoadBalancer lb;

    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object key) {
        // 获取所以UP状态的server
        List<Server> servers = lb.getReachableServers();
        // 获取到排除了指定端口的所有剩余Servers
        List<Server> availableServers = getAvailableServers(servers);
        // 对剩余的Servers通过随机方式获取一个Server
        return getAvailableRandomServer(availableServers);
    }

    // 对剩余的Servers通过随机方式获取一个Server
    private Server getAvailableRandomServer(List<Server> servers) {
        // 获取一个[0,servers.size)的整数
        int index = new Random().nextInt(servers.size());
        return servers.get(index);
    }

    // 获取到排除了指定端口的所有剩余Servers
//    private List<Server> getAvailableServers(List<Server> servers) {
//        //若没有指定要排除的port，则直接返回所有Server
//        if(excludePorts == null || excludePorts.size() == 0){
//            return null;
//        }
//
//        // 用于存放真正可以的Server
//        List<Server> aservers = new ArrayList<>();
//        for (Server server : servers) {
//            boolean isExclude = false;
//            // 将当前遍历Server的端口号与要排除的端口号进行对比
//            for (Integer port : excludePorts) {
//                if (server.getPort() == port){
//                    isExclude = true;
//                    break;
//                }
//            }
//            if (!isExclude){
//                aservers.add(server);
//            }
//        }
//        return aservers;
//    }

    // 获取到排除了指定端口的所有剩余Servers  使用lambda实现
    private List<Server> getAvailableServers(List<Server> servers) {
        //若没有指定要排除的port，则直接返回所有Server
        if(excludePorts == null || excludePorts.size() == 0){
            return null;
        }

        // 用于存放真正可以的Server
        List<Server> aservers = servers.stream()
                // 只要是能使filter()参数结果为true的元素就能用过过滤
                // noneMatch() 用于判断stream中的元素是否全部都不符合，只要找到一个符合的元素该方法就返回false
                .filter(server -> excludePorts.stream().noneMatch(port -> server.getPort() == port))
                .collect(Collectors.toList());

        return aservers;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
