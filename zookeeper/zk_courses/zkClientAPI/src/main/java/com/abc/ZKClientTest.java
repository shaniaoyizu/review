package com.abc;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created on 2020-07-23
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ZKClientTest {
    // 集群节点
    private static final String CLUSTER = "zkOS:2181";
    // 要操作的节点路径
    private static final String PATH = "/zkClient";

    public static void main(String[] args) {
        // 创建客户端(会话)
        ZkClient zkClient = new ZkClient(CLUSTER);
        // 创建节点
//        String nodeName = zkClient.create(PATH, "hello", CreateMode.PERSISTENT);
//        System.out.println("创建一个节点：" + nodeName);
//
//        // 读取节点数据内容
//        Object data = zkClient.readData(PATH);
//        System.out.println(data);

        // 创建子节点
//        zkClient.create(PATH + "/aaa", "helloAAA", CreateMode.PERSISTENT_SEQUENTIAL);
//        zkClient.create(PATH + "/aaa", "helloBBB", CreateMode.PERSISTENT_SEQUENTIAL);
//        zkClient.create(PATH + "/aaa", "helloCCC", CreateMode.PERSISTENT_SEQUENTIAL);
//
//        // 查看子节点列表
//        List<String> list = zkClient.getChildren(PATH);
//        System.out.println(list);

        // 注册watcher(监听数据内容的变更)
        zkClient.subscribeDataChanges(PATH, new IZkDataListener() {
            /**
             * 当数据内容发生变更时会触发该方法的执行
             * @param dataPath 监听的路劲
             * @param data 变更之后的数据内容
             * @throws Exception
             */
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("节点" + dataPath + "的数据已经更新为" + data);
            }

            /**
             * 当数据内容删除是会触发给方法的执行
             * @param dataPath 监听的路劲
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println(dataPath + "的数据内容被删除了");
            }
        });

        // 更新数据内容
//        if (zkClient.exists(PATH)){
//            zkClient.writeData(PATH,"world");
//            Object data = zkClient.readData(PATH);
//            System.out.println("更新过的数据内容为：" + data);
//        }

        if (zkClient.exists(PATH + "/aaa0000000000")) {
            zkClient.delete(PATH + "/aaa0000000000");
        }
    }
}
