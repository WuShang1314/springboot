package cn.lzy.customconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration//指定当前的类CoustomProperties是一个自定义的类
@PropertySource("classpath:custom.properties")//指定自定义配置文件的路径和名字
@EnableConfigurationProperties(CustomProperties.class)//开启属性自动注入
@ConfigurationProperties(prefix = "xin")//前缀调动开源
public class CustomProperties {
    private int id;
    private String name;
    private int age;//年龄
    private String[] hobby;//爱好
    private List electProduct;//电子产品
    private Map friends;//朋友

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public List getElectProduct() {
        return electProduct;
    }

    public void setElectProduct(List electProduct) {
        this.electProduct = electProduct;
    }

    public Map getFriends() {
        return friends;
    }

    public void setFriends(Map friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "CustoProperyies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", electProduct=" + electProduct +
                ", friends=" + friends +
                '}';
    }
}
