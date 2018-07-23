package com.haotliu.zookeeper.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping(value = "/shim")
public class ZookeeperController {
    @RequestMapping(value = "/GetFile/{key}", method = RequestMethod.GET)
    public File zooGetFile(@PathVariable  String key){
        return null;
    }

    @RequestMapping(value = "/WriteFile/{key}", method = RequestMethod.POST)
    public void zooWriteFile(@PathVariable String key){
        
    }
}
