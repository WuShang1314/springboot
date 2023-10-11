package cn.lzy.web.functionsion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class My implements WebMvcConfigurer/*, HandlerInterceptor*/ {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/love").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }
    //拦截器
    @Autowired
    Mi mi;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(mi)
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html");
    }
}
