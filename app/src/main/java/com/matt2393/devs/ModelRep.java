package com.matt2393.devs;

/**
 * Created by matt2393 on 11-04-18.
 */

public class ModelRep {
    private String name;
    private String clone_url;
    private String language;

    public ModelRep() {
    }

    public ModelRep(String name, String clone_url, String language) {

        this.name = name;
        this.clone_url = clone_url;
        this.language = language;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
