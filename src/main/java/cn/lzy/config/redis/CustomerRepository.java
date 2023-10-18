package cn.lzy.config.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/12 16:27
 * @Version 1.0
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);

    // 根据用户名查找id
    @Transactional
    @Query("SELECT c.id FROM t_customer c WHERE c.username = ?1")
    Integer findIdByUsername(String username);

    // 根据id修改信息
    @Transactional
    @Modifying
    @Query("UPDATE t_customer c SET c.username= ?1 WHERE  c.id = ?2")
    int updateById(String username, Integer id);

}
