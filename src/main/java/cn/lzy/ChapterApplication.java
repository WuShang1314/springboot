package cn.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.ResponseBody;

//启动类
/*@ServletComponentScan*/
@SpringBootApplication()
@EnableCaching
@EnableAsync

@EnableScheduling//开启基于注释的异步和同步任务支持(第九章定时任务)

//@ImportResource("classpath:xmlproperties.xml")

public class ChapterApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(ChapterApplication.class);
    }
    public static void main(String[] args){

        SpringApplication.run(ChapterApplication.class,args);
    }
}