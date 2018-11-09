package com.example.demo;

import com.google.common.base.Charsets;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;


public class MyZkSerializer implements ZkSerializer {
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        return new String(bytes, Charsets.UTF_8);
    }
    public byte[] serialize(Object obj) throws ZkMarshallingError {
        return String.valueOf(obj).getBytes(Charsets.UTF_8);
    }
}


