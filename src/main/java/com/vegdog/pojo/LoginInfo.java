package com.vegdog.pojo;

public class LoginInfo {
    private Integer id;
    private String username;
    private String name;
    private String token;

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString method
    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    // 无参构造器
    public LoginInfo() {
    }

    // 全参构造器
    public LoginInfo(Integer id, String username, String name, String token) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.token = token;
    }
}
