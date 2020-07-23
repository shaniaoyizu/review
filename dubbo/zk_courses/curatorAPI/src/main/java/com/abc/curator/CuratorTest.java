package com.abc.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created on 2020-07-23
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class CuratorTest {
    // 集群节点
    private static final String CLUSTER = "zkOS:2181";
    // 要操作的节点路径
    private static final String ROOT_PATH = "curator";

    public static void main(String[] args) throws Exception {
        // 创建重试策略：重试间隔1秒，最多重试3次
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);

        // 创建客户端(会话)
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(CLUSTER)
                .sessionTimeoutMs(15000)    // 会话超时时限
                .connectionTimeoutMs(13000) // 连接超时时限
                .retryPolicy(retryPolicy)
                .namespace(ROOT_PATH)
                .build();

        // 开启客户端
        client.start();

        String nodePath = "/host";

        // 创建该节点的子节点(默认为持久节点，且当前没有指定数据内容)
        // 即创建/curator/host
//        client.create().forPath(nodePath);
//        // 包含数据内容的持久子节点
//        client.create().forPath(nodePath,"hello".getBytes());
//        // 创建临时节点
//        client.create().withMode(CreateMode.EPHEMERAL).forPath(nodePath,"hello".getBytes());
        // 若要创建的当前子节点的父节点不存在，则会先创建父节点再创建子节点
//        String nodeName = client.create().creatingParentContainersIfNeeded()
//                .withMode(CreateMode.PERSISTENT)
//                .forPath(nodePath, "hello".getBytes());
//        System.out.println("新创建的节点为：/"+ ROOT_PATH + nodeName);

        // 获取数据内容并注册数据内容watcher
//        byte[] data = client.getData().usingWatcher(
//                (CuratorWatcher) event -> System.out.println(event.getPath() + "数据内容发生了变化")).forPath(nodePath);
//        System.out.println("当前节点数据内容：" + new String(data));
//
//        client.setData().forPath(nodePath, "world".getBytes());
//        byte[] newData = client.getData().forPath(nodePath);
//        System.out.println("更新过的数据为：" + new String(newData));

        // 获取子节点列表并注册子节点列表变化watcher
//        List<String> children = client.getChildren().usingWatcher(
//                (CuratorWatcher)event -> System.out.println(event.getPath() + "的子节点列表发生变化")).forPath("/");
//        System.out.println("/curator子节点列表：" + children);
//
//        // 再为/curator增加一个子节点
//        client.create().forPath("/port");
//        List<String> list = client.getChildren().forPath("/");
//        System.out.println("当前/curator节点的子节点列表为：" + list);

        // 删除节点
        if (client.checkExists().forPath("/") != null){
            client.delete().deletingChildrenIfNeeded().forPath("/");
        }
    }
}
