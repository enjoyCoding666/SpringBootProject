package com.example.demo;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.log4j.Logger;

import java.util.List;

/**
 *  获取子节点列表
 */
public class ChildrenPath {
    private static Logger logger=Logger.getLogger(ChildrenPath.class);

    public static void main(String[] args) {
        String zkServer="127.0.0.1:2181";
        String path="/";
        ZkClient zkClient=new ZkClient(zkServer,5000);
        //监控节点,节点数据改变时会收到通知
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
              logger.debug(parentPath+" 's child changed , currentChilds:"+currentChilds);
            }
        });
        logger.debug("子节点列表如下："+zkClient.getChildren(path));
    }
}
