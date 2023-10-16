package cn.lzy.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/12 16:27
 * @Version 1.0
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    public Customer getCustomer(String username){
        Customer customer=null;
        Object o = redisTemplate.opsForValue().get("customer_"+username);
        if (o!=null){
            customer=(Customer) o;
        }else {
            customer = customerRepository.findByUsername(username);
            if (customer!=null){
                redisTemplate.opsForValue().set("customer_"+username,customer);
            }
        }
        return customer;
    }
    public List<Authority> getCustomerAuthority(String username){
        List<Authority> authorities=null;
        Object o = redisTemplate.opsForValue().get("authorities_"+username);
        if (o!=null){
            authorities=(List<Authority>) o;
        }else {
            authorities=authorityRepository.findAuthoritiesByUsername(username);
            if (authorities.size()>0){
                redisTemplate.opsForValue().set("authorities_"+username,authorities);
            }
        }
        return authorities;
    }
}
