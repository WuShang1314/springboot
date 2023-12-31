package cn.lzy.config.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/12 16:25
 * @Version 1.0
 */
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    @Query(value = "select a.* from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username =?1",nativeQuery = true)
    public List<Authority> findAuthoritiesByUsername(String username);

}
