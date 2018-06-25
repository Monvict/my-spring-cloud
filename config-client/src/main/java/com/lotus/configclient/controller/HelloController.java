package com.lotus.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tony
 * 2018-06-25 10:44
 **/
@RestController
public class HelloController {

    // https://github.com/Monvict/learngit/blob/master/repo-conf/client-config-dev.properties 上的值
    @Value("${lotus.hello}")
    private String valFromGit;

    @RequestMapping("/conf")
    public String getConfig() {
        return valFromGit;
    }
}
