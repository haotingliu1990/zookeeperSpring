package com.haotliu.zookeeper.zookeeperRepo;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class ZooKeeperOperation {
    @Value("${zookeeper.connect.value}")
    String connectString;

    int sessionTimeOut = 2000;

    Watcher watcher;
    ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeOut,watcher);

    public ZooKeeperOperation() throws IOException {
    }

    public String zookeeperGetFile(String path) throws KeeperException, InterruptedException {
        byte[] tmpResult = zooKeeper.getData(path, null, null);
        String result = new String(tmpResult, StandardCharsets.UTF_8);
        return result;
    }

    public void zookeeperWriteFile(String key, String shimFile) throws KeeperException, InterruptedException {
        String path = "/" + key;
        byte[] content = path.getBytes(Charset.forName("UTF-8"));
        zooKeeper.create(path, content, null, CreateMode.PERSISTENT);
    }


    public void zookeeperUpdateFile(String key, String shimFile){

    }
}
