package com.haotliu.zookeeper.databaseRepo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class DatabaseOperation {
    private HashMap<String, String> database = new HashMap<>();
    public void writeToDatabase(String key, String path){
        database.put(key, path);
    }

    public String readDatabase(String key){
        return database.get(key);
    }
}
