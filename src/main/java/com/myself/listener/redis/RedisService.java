package com.myself.listener.redis;

import com.myself.listener.mapper.CityMapper;
import com.myself.listener.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-11 15:10
 * @apiNote
 */
@Component
public class RedisService {

    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    private CityMapper mapper;

    public void ResetCity(String key, ServletContext context){
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
        List<City> cityList = mapper.selectAll();
        int num = 0;
        for (City city : cityList) {
            redisTemplate.opsForList().rightPush("cityList", city);
            num ++;
        }
        System.out.println("重新添加的城市数量是："+num);
        List list = redisTemplate.opsForList().range("cityList", 0, -1);
        context.removeAttribute("cityList");
        context.setAttribute("cityList",list);
    }

    public void deleteCity(String city, ServletContext context){
        Long cityNum = redisTemplate.opsForList().remove("cityList", 0, city);
        System.out.println("已经删除的城市的个数是："+cityNum);
        List list = redisTemplate.opsForList().range("cityList", 0, -1);
        context.removeAttribute("cityList");
        context.setAttribute("cityList",list);
    }

    public void addCity(String city, ServletContext context){
        redisTemplate.opsForList().rightPush("cityList",city);
        List list = redisTemplate.opsForList().range("cityList", 0, -1);
        context.removeAttribute("cityList");
        context.setAttribute("cityList",list);
    }
}
