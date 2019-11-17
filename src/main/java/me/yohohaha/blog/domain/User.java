package me.yohohaha.blog.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User 实体
 * created at 2019/11/17 13:05:54
 *
 * @author Yohohaha
 */
public class User {
    /**
     * 实体唯一标识
     */
    private Long id;
    private String name;
    private String email;

    public User() {
    }

    public User(final Long id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
