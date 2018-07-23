package com.haotliu.zookeeper.databaseRepo;

import java.util.HashMap;

public class DatabaseOperation {
    private HashMap<String, String> database = new HashMap<>();
    public void writeToDatabase(String key, String path){
        database.put(key, path);
    }

    public String readDatabase(String key){
        return database.get(key);
    }
}
