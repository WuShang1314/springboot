package cn.lzy.service09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/22 18:52
 * @Version 1.0
 */
@RestController
public class MyAsyncController {
    //http://localhost:8091/sendSMS
    //http://localhost:8091/statistics

    @Autowired
    private MyAsyncService myAsyncService;
    @Autowired
    private MyAsyncService myService;

    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception{
        Long startTime=System.currentTimeMillis();
        myAsyncService.sendSMS();
        Long endTime=System.currentTimeMillis();
        System.out.println("主流耗时："+(endTime-startTime));
        return "success";
    }
    @GetMapping("/statistics")
    public String statistics() throws Exception {
        Long startTime = System.currentTimeMillis();
        Future<Integer> futureA = myService.processA();
        Future<Integer> futureB = myService.processB();
        int total = futureA.get() + futureB.get();
        System.out.println("异步任务数据统计汇总结果： " + total + " " + "执行时间: " + DataUtils.getData(DataUtils.data1));
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时： "+(endTime-startTime));
        return "success";
    }
}
