package cn.lzy;

import cn.lzy.configbean.Pres;
import cn.lzy.configbean.Student;
import cn.lzy.configbean.User;
import cn.lzy.controller.ChapterController;
import cn.lzy.customconfig.MyProperties;
import cn.lzy.mybatiscatalog.Comment;
import cn.lzy.mybatiscatalog.CommentMapper;
import cn.lzy.mybatiscatalog.redis.Address;
import cn.lzy.mybatiscatalog.redis.Family;
import cn.lzy.mybatiscatalog.redis.Person;
import cn.lzy.mybatiscatalog.redis.RedisRepository;
import cn.lzy.profilelconfig.DBConnector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTestAppication {
    private String TAG="ChapterController";
    @Autowired//取出

    ChapterController chapterController;


/*  @Autowired
  @Value("${student.id}")
      int id;*/
    @Autowired
    User user;
    @Autowired
    Pres pres;
    @Autowired
    Student student;
//   @Autowired
//   CustomProperties customProperties;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    DBConnector dbConnector;

   @Autowired
   CommentMapper commentMapper;

   @Autowired
    RedisRepository RedisRepository;//9.05

   /* @Test
    public void studentTest(){
        System.out.println(student);
    }*/


    @Test
    public  void contextLoads() {
        //System.out.println("单元测试返回的id数据---"+id);
        /*System.out.println("单元测试返回的user数据---"+user);
        System.out.println("单元测试返回的pres数据---"+pres);
        System.out.println(student);*/
        MyProperties myProperties = (MyProperties) applicationContext.getBean("MyProperties");
        if (myProperties != null) {
            myProperties.getResult();
           // System.out.println("MyProperties 类注入不成功");
            System.out.println(myProperties);
//
//        } else {
//            myProperties.getResult();
//        }
//        dbConnector.config();
//        System.out.println(dbConnector.config());
       /* Comment comment=commentMapper.finById(2);
        System.out.println("单元测试返回的comment数据---"+comment);

        Comment comment1=new Comment();
        comment1.setaId(5);
         comment1.setContent("追风");
         comment1.setAuthor("咋地");
         commentMapper.updateComment(comment1);
        System.out.println("插入的数据"+comment1);
*/
        /*List<Person> listPerson=RedisRepository.findByLastname("夜");
        System.out.println(listPerson);//9.05*/
        }
//9.05
   /* @Test//单元测试目录
    public void saveRedisPerson(){
        Person personRedis=new Person();
        personRedis.setFirstname("白");
        personRedis.setLastname("夜");
        Address address=new Address();
        address.setCity("冥府");
        address.setCity("地狱");
        personRedis.setAddress(address);
        List<Family> list =new ArrayList<>();
        Family hua=new Family("玫瑰","热爱");
        Family yu=new Family("海棠","一霎");
        list.add(hua);
        list.add(yu);
        personRedis.setFamilyList(list);
        Person personResult=RedisRepository.save(personRedis);
        System.out.println(personResult);
    }*/


   /* @Test
    public  void contextLoads(){
        System.out.println("单元测试返回的数据"+ chapterController.sayHello());
        System.out.println("单元测试返回的student数据"+student);
        System.out.println("单元测试返回的数据"+user);
        System.out.println("单元测试返回的pres数据"+pres);
        }*/
 /*   String TAG="ChapterTestAppication";
    @Autowired
    ChapterController mChapterController;*/

    }
}
