package com.myself.listener.model;

import java.io.Serializable;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-11 15:11
 * @apiNote
 */
public class City implements Serializable {
    private Integer id;
    private String cityName;

    public City() {
    }

    public City(Integer id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
