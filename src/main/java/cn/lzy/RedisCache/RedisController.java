package cn.lzy.RedisCache;

import cn.lzy.mybatiscatalog.jpa.Dis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/1 20:27
 * @Version 1.0
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;
    @GetMapping("/getRedis/{id}")
    public Dis findById(@PathVariable("id") int comment_id){
        Dis dis=redisService.findById(comment_id);
        return dis;
    }
    @GetMapping("/update/{id}/{author}")
    public Dis updateComment(@PathVariable("id") int comment_id,
                             @PathVariable("author")String author){
        Dis comment=redisService.findById(comment_id);
        comment.setAuthor(author);
        Dis updateComment=redisService.updateComment(comment);
        return updateComment;
    }
    @GetMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id")int comment_id){
        redisService.deleteComment(comment_id);
    }
}
