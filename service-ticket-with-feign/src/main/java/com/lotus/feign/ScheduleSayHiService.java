package com.lotus.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过Feign调用SERVICE-ACCOUNT微服务的接口，并将ScheduleSayHiService自身封装
 * 为一个Service可以在项目中其它位置使用
 */
@FeignClient(name = "SERVICE-ACCOUNT")
public interface ScheduleSayHiService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String schedualSayHi(@RequestParam(value = "name") String name);
}
