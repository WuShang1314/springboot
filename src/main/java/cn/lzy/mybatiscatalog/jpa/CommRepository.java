package cn.lzy.mybatiscatalog.jpa;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName ${黄金福}
 * @date 2023/9/26 11:56
 * @Version 1.0
 */
public interface CommRepository extends JpaRepository<CommentJPA,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE t_article c SET c.title= ?1 where c.id= ?2")
    public int updateAllBy(String title,Integer id);
}
