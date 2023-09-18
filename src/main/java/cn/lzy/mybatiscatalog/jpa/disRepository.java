package cn.lzy.mybatiscatalog.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface disRepository {
    public List<Dis> findByAuthorNotNull();
    @Query("select c from comment c WHERE c.aid=?1")
    public List<Dis> getDiscussPaged(Integer aid,Package pageable);
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM t_comment  WHERE  a_Id = ?1",nativeQuery = true)
    public List<Dis> getDiscussPaged2(Integer aid,Package pageable);
    @Transactional
    @Modifying
    @Query("DELETE comment c WHERE c.id = ?1")
    public int deleteDiscuss(Integer id);

}
