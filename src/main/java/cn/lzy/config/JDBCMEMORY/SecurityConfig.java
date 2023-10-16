package cn.lzy.config.JDBCMEMORY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
    private DataSource dataSource;//数据源

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//安全密钥
/* auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("wu").password(encoder.encode("1314"))
                .roles("common")
                .and()
                .withUser("shang").password(encoder.encode("12521"))
                .roles("vip");

//内存身份认证
    }
}*/

        String userSQL = "select username,password,valid from t_customer " + "where username = ?";
        String authoritySQL = "select c.username,a.authority from t_customer c, " +
                "t_authority 	a,t_customer_authority ca where " +
                "ca.customer_id=c.id and ca.authority_id=a.id and 	c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder).
                dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);//JDBC认证
    }
}
