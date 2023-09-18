package cn.lzy.configbean;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "student")

public class Student {

    private int id;
    private String  name;
    private String[] hobby;
    private List electProduct;
    private Map friends;
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", electProduct=" + electProduct +
                ", friends=" + friends +
                ", course=" + course +
                '}';
    }

    public void setName(String name) {
        this.name = name;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
