package com.example.demo;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.apache.log4j.Logger;

/**
 * 获取节点数据
 */
public class PathData {
    private static Logger logger=Logger.getLogger(PathData.class);

    public static void main(String[] args) {
        String zkServer="127.0.0.1:2181";
        String path="/zk-permanent";
        ZkClient zkClient=new ZkClient(zkServer,5000);
        logger.info("使用zkClient查询节点数据：");
        //zkClient需要设置序列化后，才可以获取节点数据。不然会报错：ZkMarshallingError: java.io.EOFException
        //默认的SerializableSerializer()可以会出现乱码。以下采用自定义的序列化设置
//        zkClient.setZkSerializer( new SerializableSerializer());
        zkClient.setZkSerializer(new MyZkSerializer());
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                logger.debug("Node:" +dataPath+" changed, new data:"+data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                logger.debug("Node:"+dataPath+"deleted");
            }
        });
        logger.debug(path+"节点下的数据为："+ zkClient.readData(path));

    }
}
