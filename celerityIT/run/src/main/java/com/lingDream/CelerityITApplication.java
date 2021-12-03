package com.lingDream;

import com.lingDream.celerityIT.mapper.CelerityITMapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update.UpdateCelerityItWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CelerityITApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CelerityITApplication.class, args);
        CelerityITMapper mapper = run.getBean(CelerityITMapper.class);
        mapper.insertData(new UpdateCelerityItWrapper().setTableName("chinese"));
    }
}
