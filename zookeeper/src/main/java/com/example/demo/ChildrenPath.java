package com.example.demo;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 *  获取子节点列表
 */
public class ChildrenPath {
    public static void main(String[] args) {
        String zkServer="192.168.0.116:2181";
        String path="/zk-permanent";
        ZkClient zkClient=new ZkClient(zkServer,5000);
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath+" 's child changed , currentChilds:"+currentChilds);
            }
        });
        System.out.println(zkClient.getChildren(path));
    }
}
