package com.myself.listener.service;

import com.myself.listener.model.City;

import java.util.List;
import java.util.Map;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-11 15:12
 * @apiNote
 */
public interface CityService {
    List<City> selectAll();

    int addCity(String cityName);
}
