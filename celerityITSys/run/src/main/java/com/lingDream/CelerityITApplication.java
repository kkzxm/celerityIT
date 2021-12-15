package com.lingDream;

import com.lingDream.celerityIT.tool.cache.Cache;
import com.lingDream.delerityIT.Flow.systemStart.CacheDataBaseCatalogFlow;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CelerityITApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CelerityITApplication.class, args);

        SqlSessionFactory sqlSessionFactory = run.getBean(SqlSessionFactory.class);
        Cache cache = run.getBean(Cache.class);
        new CacheDataBaseCatalogFlow().init(sqlSessionFactory, cache);
    }
}
