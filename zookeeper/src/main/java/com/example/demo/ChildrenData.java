package com.example.demo;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * 获取节点数据
 */
public class ChildrenData {
    public static void main(String[] args) {
        String zkServer="127.0.0.1:2181";
        String path="/zk-permanent";
        ZkClient zkClient=new ZkClient(zkServer,5000);
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("Node:" +dataPath+" changed, new data:"+data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("Node:"+dataPath+"deleted");
            }
        });

        System.out.println((String) zkClient.readData(path));

    }
}
