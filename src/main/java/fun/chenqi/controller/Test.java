package fun.chenqi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chenqi
 * @date 2019/7/8 13:37
 */

@RestController
@RequestMapping("test")
public class Test {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test01")
    public String hello(@RequestParam("id") String id,@RequestHeader String userName) {
        System.out.println(userName);
//        for (int i = 0; i < 100000000; i++) {
//            System.out.println(i);
//        }
        System.out.println(id);
        return id;
    }
}
