package cn.lzy.domain;


import cn.lzy.mybatiscatalog.jpa.CommRepository;
import cn.lzy.mybatiscatalog.jpa.CommentJPA;
import cn.lzy.mybatiscatalog.jpa.Dis;
import cn.lzy.mybatiscatalog.jpa.DisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName ${黄金福}
 * @date 2023/9/25 16:38
 * @Version 1.0
 */
@RestController
public class JPAController {
    @Autowired
    private DisRepository disRepository;
    @GetMapping("/get/{id}")
   @Cacheable(cacheNames = "comment"/*表名*/)
    public Dis findById(@PathVariable("id") int comment_id){
        Optional<Dis> optional=disRepository.findById(comment_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    @Autowired
    private CommRepository commRepository;
    @GetMapping("/gette/{id}")
    @Cacheable(cacheNames = "article")
    public CommentJPA findById2(@PathVariable("id") int article_id){
        Optional<CommentJPA> optional=commRepository.findById(article_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
