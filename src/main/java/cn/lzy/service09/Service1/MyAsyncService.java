package cn.lzy.service09.Service1;

import cn.lzy.service09.Service1.DataUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/22 18:49
 * @Version 1.0
 */
@Service
public class MyAsyncService {
    @Async
    public Future<Integer> processA() throws Exception{
        Long startTimeA=System.currentTimeMillis();
        System.out.println("开始计算1-1000的值的总和：" + "执行时间:" + DataUtils.getData(DataUtils.data1));
        Thread.sleep(4000);
      /*  int total=0;
        for (int i=0;i<=1000;i++){
            total=total+i;
        }*/
        int total1=process1();
        System.out.println("1-1000计算的值为：" + total1);
        Long endTime=System.currentTimeMillis();
        System.out.println("1-1000的计算时长为："+ (endTime-startTimeA));
        return new AsyncResult<>(total1);
    }

    @Async
    public Future<Integer> processB() throws Exception{
        Long startTimeB=System.currentTimeMillis();
        System.out.println("开始计算1000-2000的值的总和：" + "执行时间:" + DataUtils.getData(DataUtils.data1));
        Thread.sleep(4000);
       /* int total2=1000;
        for (int i=0;i<=2000;i++){
            total2=total2+i;
        }*/
        int total2=process2();
        System.out.println("1000-2000计算的值为：" + total2);
        Long endTime=System.currentTimeMillis();
        System.out.println("1000-2000的计算时长为："+ (endTime-startTimeB));
        System.out.println( "1000-2000的值计算结束时间为: " + DataUtils.getData(DataUtils.data1));
        return new AsyncResult<>(total2);
    }

    @Async
    public Future<Integer> processC() throws Exception {
        Long startTimeB=System.currentTimeMillis();
        System.out.println("开始计算1-1000值+1000-2000的值：" + "执行时间:" + DataUtils.getData(DataUtils.data1));
        Thread.sleep(6000);
        int total3=process1()+process2();
        System.out.println("1-1000值+1000-2000的值为：" + total3);
        Long endTime=System.currentTimeMillis();
        System.out.println("1-1000的值 + 1000-2000的值计算时长为："+ (endTime-startTimeB));
        System.out.println( "1-1000的值 + 1000-2000的值 计算结束时间为: " + DataUtils.getData(DataUtils.data1));
        return new AsyncResult<>(total3);
    }
    public int process1(){
        int total1=0;
        for (int i=0;i<=1000;i++){
            total1=total1+i;
        }
        return total1;
    }
    public int process2(){
        int total2=0;
        for (int i=1000;i<=2000;i++){
            total2=total2+i;
        }
        return total2;
    }

    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime)); }

}
