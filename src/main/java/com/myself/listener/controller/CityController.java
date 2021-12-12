package com.myself.listener.controller;

import com.myself.listener.model.City;
import com.myself.listener.redis.RedisService;
import com.myself.listener.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-11 15:12
 * @apiNote
 */
@Controller
public class CityController {

    @Autowired(required = false)
    private CityService cityService;

    @Autowired(required = false)
    private RedisService redisService;

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addCity(String cityName, HttpServletRequest request){

        ServletContext context = request.getServletContext();
        int result = cityService.addCity(cityName);
        String msg = "添加城市成功";
        if (result == 1) {
            redisService.resetCity("cityList",context);
        }else {
            msg = "添加城市失败";
        }
        return msg;
    }

}
