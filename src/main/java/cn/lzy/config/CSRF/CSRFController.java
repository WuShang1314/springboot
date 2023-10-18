package cn.lzy.config.CSRF;

import cn.lzy.config.redis.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/16 10:53
 * @Version 1.0
 */

@Controller
public class CSRFController {

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/toUpdate")//http://localhost:8091/toUpdate
    public String toUpdate(){
        return "csrf/csrfTest";
    }
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam String username, @RequestParam String password,
                             HttpServletRequest request){
        System.out.println(username);
        System.out.println(password);
        String csrf_token=request.getParameter("_csrf");
        System.out.println(csrf_token);
        // 获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        // 获取登录的用户信息
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal.getUsername());
        // 获取登录的用户id
        Integer updateId = customerRepository.findIdByUsername(principal.getUsername());
        System.out.println(updateId);
        // 更新用户表中对应id的用户名
        Integer result = customerRepository.updateById(username, updateId);
        return "OK，已完成更新";
    }
}
