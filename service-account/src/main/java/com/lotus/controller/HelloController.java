package com.lotus.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lotus.dto.City;
import com.lotus.dto.Point;
import com.lotus.dto.Response;
import com.lotus.dto.User;
import com.lotus.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private CityMapper cityMapper;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name") String name){
        return "[ACCOUNT] Hello " + name + ", I am from port" + port;
    }

    @RequestMapping("/hello")
    public Response hello() {
        return new Response("400", "鉴权失败");
    }

    @PostMapping("/valid")
    public Response valid(@RequestBody @Valid User user) {
        log.info("Accept user {}", user);
        return new Response("200", "成功");
    }

    @RequestMapping("/city/{id}")
    public City getCityById(@PathVariable("id") String id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/city/page/{pageNum}/{pageSize}")
    public PageInfo<City> getAll(@PathVariable("pageNum") int pageNum,
                             @PathVariable("pageSize") int pageSize) {
        // 设置分页（一定要在最开始设置）
        PageHelper.startPage(pageNum, pageSize);

        List<City> cities = cityMapper.selectByPage(pageNum);

        PageInfo<City> info = new PageInfo<>(cities);

        return info;
    }

    @PostMapping("/point")
    public String getPoint(@RequestBody Point point) {
        log.info("receive {}", point);
        return "success";
    }

    @RequestMapping("/point/{lat}/{lng}")
    public String getPoint2(@PathVariable("lat") double lat,
                            @PathVariable("lng") double lng) {
        log.info("receive lat {}", lat);
        log.info("receive lng {}", lng);
        return "success";
    }
}
