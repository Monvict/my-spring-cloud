package com.lotus.controller;

import com.lotus.feign.ScheduleSayHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleSayHiController {

    @Autowired
    private ScheduleSayHiService service;

    @RequestMapping("/schedual-hi")
    public String schedualSayHi(@RequestParam(value = "name") String name,
                                @RequestHeader("Accept-Encoding") String encoding,
                                @RequestHeader("User-Agent") String header,
                                @RequestHeader("ClientId") String id,
                                @RequestHeader("TimeStamp") String timeStamp) {

        return "TICKET" + service.schedualSayHi(name) + "\r\n"
                + "Accept-Encoding : " + encoding + "\r\n"
                + "User-Agent: " + header + "\r\n"
                + "ClientId" + id + "\r\n"
                + "TimeStamp" + timeStamp;
    }
}
