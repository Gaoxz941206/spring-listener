package com.myself.listener.service.impl;

import com.myself.listener.mapper.CityMapper;
import com.myself.listener.model.City;
import com.myself.listener.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-11 15:12
 * @apiNote
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired(required = false)
    private CityMapper mapper;

    @Override
    public List<City> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int addCity(String cityName) {
        return mapper.insertCity(cityName);
    }
}
