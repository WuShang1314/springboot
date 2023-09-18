package cn.lzy.profilelconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevDBConnector implements DBConnector{

    @Override
    public String config() {
        return "这是开发环境";
    }
}
