package cn.lzy.service09;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.util.concurrent.Future;

import static org.thymeleaf.util.DateUtils.*;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/22 18:49
 * @Version 1.0
 */
@Service
public class MyAsyncService {
    @Async
    public Future<Integer> processA() throws Exception{
        System.out.println("开始计算1-1000的值的总和：" + "执行时间:" + DataUtils.getData(DataUtils.data1));
        Long startTimeA=System.currentTimeMillis();
        Thread.sleep(4000);
        int total=0;
        for (int i=0;i<=1000;i++){
            total=total+i;
        }
        System.out.println("1-1000计算的值为：" + total);
        Long endTime=System.currentTimeMillis();
        System.out.println("1-1000的计算时长为："+ (endTime-startTimeA));
        return new AsyncResult<>(total);
    }

    @Async
    public Future<Integer> processB() throws Exception{
        System.out.println("开始计算1000-2000的值的总和：" + "执行时间:" + DataUtils.getData(DataUtils.data1));
        Long startTimeB=System.currentTimeMillis();
        Thread.sleep(5000);
        int total2=1000;
        for (int i=0;i<=2000;i++){
            total2=total2+i;
        }
        System.out.println("1000-2000计算的值为：" + total2);
        Long endTime=System.currentTimeMillis();
        System.out.println("1000-2000的计算时长为："+ (endTime-startTimeB));
        return new AsyncResult<>(total2);
    }
    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime)); }

}
