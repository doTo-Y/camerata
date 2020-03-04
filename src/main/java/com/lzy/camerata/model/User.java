package com.lzy.camerata.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    public int getId() {
        return id;
    }

    private String name;
    private String bio;
    private long githubId;
    private String githubLogin;
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public long getGithubId() {
        return githubId;
    }

    public void setGithubId(long githubId) {
        this.githubId = githubId;
    }

    public String getGithubLogin() {
        return githubLogin;
    }

    public void setGithubLogin(String githubLogin) {
        this.githubLogin = githubLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", githubId=" + githubId +
                ", githubLogin='" + githubLogin + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
