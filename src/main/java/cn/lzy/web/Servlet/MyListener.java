package cn.lzy.web.Servlet;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*@WebListener*/
@Component
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("contexInitialized....");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("contextDestroyed....");
    }
}
