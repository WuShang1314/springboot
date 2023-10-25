package cn.lzy.service09.Service3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/23 20:43
 * @Version 1.0
 */
//定制邮件发送
@Service
public class SendEmailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Value("${spring.mail.username}")
    private String form;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(form);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            //发送邮件
            javaMailSender.send(message);
            System.out.println("纯文本文件发送成功");
        } catch (MailException e) {
            System.out.println("纯文本文件发送失败" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送复杂邮件（包括静态资源和附件）
     *
     * @panram to 收件人地址
     * @panram subject 邮件标题
     * @apnram text 邮件内容
     * @panram filePath 附件地址
     * @panram rscId 静态资源唯一标识
     * @panram rscPath 静态资源地址
     */
    public void sendComplexEmail(String to, String subject, String text, String filePath, String rscId,
                                 String rscPath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            //设置邮件静态资源
            FileSystemResource resource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, resource);
            //设置邮件附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //发送邮件
            javaMailSender.send(message);
            System.out.println("复杂邮件发送成功");
        } catch (MailException | MessagingException e) {
            System.out.println("复杂邮件发送失败" + e.getMessage());
            e.printStackTrace();
        }
    }

    //只发送附件
    public void sendAttachFileMail(String to, String subject, String content, File filePath) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.addAttachment(filePath.getName(), filePath);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //只发送照片
    public void sendImageMail(String to, String subject, String content, String filePath,String Id) throws MessagingException {
        //创建message
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //发件人
        helper.setFrom(form);
        //收件人
        helper.setTo(to);
        //标题
        helper.setSubject(subject);
        //true指的是html邮件，false指的是普通文本
        helper.setText(content, true);
        //添加图片
        FileSystemResource file = new FileSystemResource(new File(filePath));
        helper.addInline(Id, file);
        //发送邮件
        javaMailSender.send(message);
    }

//定制模板邮件
    public void sendTemplateEmail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            System.out.println("模板邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("模板邮件发送失败 "+e.getMessage());
            e.printStackTrace();}}


}
