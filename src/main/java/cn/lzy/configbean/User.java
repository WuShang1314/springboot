package cn.lzy.configbean;

import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component
@ConfigurationProperties(prefix = "user")
@Validated
public class User {

    @Email
    String email;
  //  @URL
    String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEmail(String email){this.email=email;}

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
