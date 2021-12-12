package com.myself.listener;

import com.myself.listener.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-12-10 16:34
 * @apiNote
 */
@Component
public class SpringListener implements ServletContextListener {

    @Autowired(required = false)
    private RedisService redisService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        redisService.resetCity("cityList",context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
