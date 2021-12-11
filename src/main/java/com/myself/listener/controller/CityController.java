package com.myself.listener.controller;

import com.myself.listener.model.City;
import com.myself.listener.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-11 15:12
 * @apiNote
 */
@Controller
public class CityController {

    @Autowired(required = false)
    private CityService cityService;

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

}
