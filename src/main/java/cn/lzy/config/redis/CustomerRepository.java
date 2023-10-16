package cn.lzy.config.redis;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/12 16:27
 * @Version 1.0
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);
}
