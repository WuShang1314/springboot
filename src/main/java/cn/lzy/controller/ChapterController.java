package cn.lzy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class ChapterController {

    public static String sayHello;
    private String TAG="ChapterController";
    @RequestMapping(value = "/hello")

    public String sayHello(){
        System.out.println(TAG+"----返回的的测试数据--");

        return "hello Spring boot 好个锤锤!!!!";
    }
}
