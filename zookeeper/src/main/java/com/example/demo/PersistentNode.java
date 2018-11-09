package com.example.demo;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.log4j.Logger;

/**
 * 添加永久节点。监控节点。更新节点数据。
 */
public class PersistentNode {
      private static Logger logger=Logger.getLogger(PersistentNode.class);

    public static void main(String[] args) throws InterruptedException {
        String path="/test";
        ZkClient zkClient=new ZkClient("127.0.0.1:2181",5000);
        //创建永久节点，如果想创建临时节点，则需要使用createEphemeral()
        zkClient.createPersistent(path,"123");
        //在节点上添加监听器Listener，节点改变或删除时就会收到通知。
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object object) throws Exception {
                logger.debug("Node "+dataPath+" changed.new data is "+object);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                logger.debug("Node "+dataPath+" deleted");
            }
        });
        logger.debug("Node data is:"+zkClient.readData(path));
        //更新节点的数据
        zkClient.writeData(path,"456");
        Thread.sleep(3000);
        logger.debug("zookeeper节点操作结束。");
    }

}
