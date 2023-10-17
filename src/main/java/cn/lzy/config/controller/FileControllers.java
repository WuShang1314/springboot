package cn.lzy.config.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/9 10:41
 * @Version 1.0
 */
@Controller
public class FileControllers {
    //影片详情
    private String TAG = "FileControllers";

    @GetMapping("detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type,
                           @PathVariable("path") String path) {
        String value = "detail/" + type + "/" + path;
        System.out.println(TAG + "-----" + value);
        return value;
    }
//自定义登录跳转
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }

/*    @GetMapping("/getuserBySession")
    @ResponseBody
    public void getUser(HttpSession httpSession) {
        Enumeration<String> names = httpSession.getAttributeNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            SecurityContextImpl attribute =
                    (SecurityContextImpl) httpSession.getAttribute(element);
            System.out.println("element: " + element);
            System.out.println("attribute: " + attribute);
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username: " + principal.getUsername());
        }
    }

    @GetMapping("/getuserByContext")
    @ResponseBody
    public void getUser2() {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("userDetails: "+context);
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails)authentication.getPrincipal();
        System.out.println(principal);
        System.out.println("username: "+principal.getUsername());
    }*/

}

