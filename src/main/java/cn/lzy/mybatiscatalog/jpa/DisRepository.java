
package cn.lzy.mybatiscatalog.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

public interface DisRepository extends JpaRepository<Dis,Integer> {
    public List<Dis> findByAuthorNotNull();
    @Query("select c from t_comment c WHERE c.aId=?1")
    public List<Dis> getDiscussPaged(Integer aid, Pageable pageable);

    @Query(value = "SELECT * FROM t_comment  WHERE  a_Id = ?1",nativeQuery = true)
    public List<Dis> getDiscussPaged2(Integer aid,Pageable pageable);
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE  c.id = ?2")
    public int updateDiscuss(String author,Integer id);
    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE  c.id = ?1")
    public int deleteDiscuss(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author=?1 where c.id=?2")
    public int updateComment(String author,Integer id);
}

