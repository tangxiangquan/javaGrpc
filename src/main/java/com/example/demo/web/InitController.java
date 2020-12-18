package com.example.demo.web;

import com.example.demo.config.HelloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiangquan.tang
 * @date 2020/12/3 13:27
 */
@RestController
@RequestMapping("/gvp/init")
public class InitController {

    @Resource
    private HelloClient helloWorldClient;

    //连接Go的gRpc服务端
    @GetMapping("/go")
    public String testGo(){
        return helloWorldClient.sayHello("World");
    }
}
