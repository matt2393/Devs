package com.matt2393.devs;

/**
 * Created by matt2393 on 11-04-18.
 */

public class ModelDev {
    private int id;
    private String login,avatar_url;
    private String html_url,repos_url;

    public ModelDev() {
    }

    public ModelDev(int id, String login, String avatar_url, String html_url, String repos_url) {

        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = html_url;
        this.repos_url = repos_url;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }
}
