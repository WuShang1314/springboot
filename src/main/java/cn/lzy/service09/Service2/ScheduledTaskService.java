package cn.lzy.service09.Service2;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/23 18:18
 * @Version 1.0
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count1 = 1;
    private Integer count2 = 1;
    private Integer count3 = 1;
    private Integer count4 = 1;
    //用fixedRate实现重复执行任务
    //代码块休眠5秒，10秒之后重复执行任务
   /* @Scheduled(fixedRate = 5000)
    public void exTest() {
        System.out.println("fixedRate 执行:" + (count1++) + "执行时长：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //用fixedRate实现重复执行任务
    //代码块休眠15秒，15秒之后重复执行任务
/*    @Scheduled(fixedRate = 15000)
    public void exTest2() {
        System.out.println("fixedRate 执行:" + (count1++) + "执行时长：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //用fixedDelay实现重复执行任务
    //代码块休眠5秒，10秒之后重复执行任务
/*    @Scheduled(fixedDelay = 5000)
    public void IqTest1() {
        System.out.println("fixedDelay 执行:" + (count2++) + "执行时长：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }*/

/*    @Scheduled(fixedDelay = 5000)
    public void IqTest2() {
        System.out.println("fixedDelay 执行:" + (count2++) + "执行时长：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }*/

    //用initialDelay实现重复执行任务
    //代码块第一次执行延迟10秒后再执行 休眠5秒，10秒之后重复执行任务
/*    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void Test1(){
        System.out.println("initialDelay 执行:" + (count3++) + "执行时长：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e3){
            e3.printStackTrace();
        }
    }*/

    //用initialDelay实现重复执行任务
    //代码块第一次执行延迟0秒后再执行 休眠5秒，5秒之后重复执行任务
/*    @Scheduled(initialDelay = 0, fixedRate = 5000)
    public void Test2(){
        System.out.println("initialDelay 执行:" + (count3++) + "执行时长：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e3){
            e3.printStackTrace();
        }
    }*/
  /*  @Scheduled(cron = "0 * * * * * ")
    public void Tests(){
        System.out.println("cron 执行:" + (count4++) + "执行时长：" + dateFormat.format(new Date()));
    }*/
}
