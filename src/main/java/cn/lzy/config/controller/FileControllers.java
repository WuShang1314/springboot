package cn.lzy.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/9 10:41
 * @Version 1.0
 */
@Controller
public class FileControllers {
    //影片详情
    private String TAG="FileControllers";
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type")String type,@PathVariable("path")String path){
        String value= "detail/"+type+"/"+path;
        System.out.println(TAG+"-----"+value);
        return value;
    }
}
