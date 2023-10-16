package cn.lzy.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ${黄金福}
 * @date 2023/10/12 16:29
 * @Version 1.0
 */
@Service
public class  UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    CustomerService customerServices;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerServices.getCustomer(username);
        List<Authority> authorities = customerServices.getCustomerAuthority(username);
        List<SimpleGrantedAuthority> list = authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
        if (customer!=null){
            UserDetails userDetails=new User(customer.getUsername(), customer.getPassword(), list);
            return userDetails;
        }else {
            throw new UsernameNotFoundException("当前用户不存在！");
        }

    }

}
