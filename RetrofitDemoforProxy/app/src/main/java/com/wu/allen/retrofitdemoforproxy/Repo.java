package com.wu.allen.retrofitdemoforproxy;

/**
 * Created by allen on 2016/9/8.
 */

public class Repo {

    /**
     * login : wuchangfeng
     * blog : allenwu.itscoder.com
     * email : wuchangfeng2015@gmail.com
     * public_repos : 20
     * followers : 58
     * following : 48
     * created_at : 2015-07-21T09:24:32Z
     */

    private String login;
    private String blog;
    private String email;
    private int public_repos;
    private int followers;
    private int following;
    private String created_at;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
