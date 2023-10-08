package cn.lzy.RedisCache;

import cn.lzy.mybatiscatalog.jpa.Dis;
import cn.lzy.mybatiscatalog.jpa.DisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/1 20:27
 * @Version 1.0
 */
@Service
public class RedisService {
    @Autowired
    private DisRepository disRepository;
    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Dis findById(int comment_id){
        Optional<Dis> optional=disRepository.findById(comment_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Dis updateComment(Dis comment){
        disRepository.updateComment(comment.getAuthor(),comment.getaId());
        return comment;
    }
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id){
        disRepository.deleteById(comment_id);
    }
}
