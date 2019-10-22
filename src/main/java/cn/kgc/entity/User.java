package cn.kgc.entity;

import java.io.Serializable;

/**
 * @author mr
 * @Date 2019/10/15 14:33
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String pwd;
    private String sex;
    private String hobby;

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getHobby() {
        return hobby;
    }

    public User setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public User(String username, String pwd, String sex, String hobby) {
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.hobby = hobby;
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public User(String id, String username, String pwd, String sex, String hobby) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.hobby = hobby;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
