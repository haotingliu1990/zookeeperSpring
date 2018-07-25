package com.haotliu.zookeeper.controllers;

import com.haotliu.zookeeper.databaseRepo.DatabaseOperation;
import com.haotliu.zookeeper.zookeeperRepo.RequestBodyRepo;
import com.haotliu.zookeeper.zookeeperRepo.ZooKeeperOperation;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/shim")
public class ZookeeperController {
    @Autowired
    DatabaseOperation databaseOperation;

    @Autowired
    ZooKeeperOperation zooKeeperOperation;

    @RequestMapping(value = "/GetFile/{key}", method = RequestMethod.GET)
    public String zooGetFile(@PathVariable String key) {
        if (databaseOperation.checkDatabase(key)) {
            String path = databaseOperation.readDatabase(key);
            try {
                String result = zooKeeperOperation.zookeeperGetFile(path);
                return result;
            } catch (KeeperException e) {
                return "";
            } catch (InterruptedException e) {
                return "";
            }
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/WriteFile", method = RequestMethod.POST)
    public void zooWriteFile(@RequestBody RequestBodyRepo body) {
        if (databaseOperation.checkDatabase(body.key)) {
            zooKeeperOperation.zookeeperUpdateFile(body.key, body.content);
        } else {
            try {
                zooKeeperOperation.zookeeperWriteFile(body.key, body.content);
            } catch (KeeperException e) {
                return;
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
