package cn.lzy;

import cn.lzy.service09.Service3.SendEmailService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @ClassName ${黄金福}
 * @date 2023/10/23 20:53
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter09 {
    @Autowired
    private SendEmailService sendEmailService;
    @Test
    public void setSendEmailService(){
        String to="3297408918@qq.com";
        String subject="【纯文本邮件】标题";
        String text="Spring Boot纯文本邮件发送内容测试";
        //发送文本文件
        sendEmailService.sendSimpleEmail(to,subject,text);
    }

    //附件
    @Test
    public void sendAttachFileMail(){
        String to="3297408918@qq.com";
        String subject="【附件邮件】标题";
        String content="Spring Boot附件邮件发送内容测试.....";
        String filePath="D:\\Download\\Spring Boot应用级开发教程.pdf";
        sendEmailService.sendAttachFileMail(to,subject,content,new File(filePath));
    }

    //图片
    @Test
    public void testSendImageEmail() throws Exception {
        String to = "3297408918@qq.com";
        String subject = "测试发送图片邮件";
        String content = "<h1></h1><img src='cid:test001'/>";
        String imgPath="C:\\Users\\86178\\Pictures\\Saved Pictures\\不良少年.jpg";
        // 发送邮件
        sendEmailService.sendImageMail(to, subject, content,imgPath,"test001");
    }

    //发送附件跟图片和文本
    @Test
    public void sendComplexEmailTest() {
        String to="3297408918@qq.com";
        String subject="【复杂邮件】标题";
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>祝大家毕业快乐！我们青春散场，呜呜...</h1>");
        String rscId = "img001";
        text.append("<img src='cid:" +rscId+"'/></body>");text.append("</html>");
        String rscPath="C:\\Users\\86178\\Pictures\\Saved Pictures\\不良少年.jpg";
        String filePath="D:\\Download\\Spring Boot应用级开发教程.pdf";
        sendEmailService.sendComplexEmail(to,subject,text.toString(),
                filePath,rscId,rscPath);
    }

    //模板邮件
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void sendTemplateEmailTest() {
        String to = "3297408918@qq.com";
        String subject = "【模板邮件】标题";
        //使用模板邮件定制邮件正文内容
        Context context = new Context();
        context.setVariable("username", "伤");
        context.setVariable("code", 1314);
        //使用TemplateEngine设置要处理的模板页面
        String emailContent;
        emailContent = templateEngine.process("emailTemplate_vercode", context);
        //发送模板邮件
        sendEmailService.sendTemplateEmail(to, subject, emailContent);
    }
}
