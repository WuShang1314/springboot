package cn.lzy.mybatiscatalog.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName ${黄金福}
 * @date 2023/9/26 11:51
 * @Version 1.0
 */
@Entity(name = "t_article")
public class CommentJPA /*implements Serializable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CommentJPA{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
