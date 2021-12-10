package com.lingDream;

import com.lingDream.celerityIT.entity.dataBase.Field;
import com.lingDream.celerityIT.entity.dataBase.Table;
import com.lingDream.celerityIT.mapper.DoFieldMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CelerityITApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CelerityITApplication.class, args);
        DoFieldMapper mapper = run.getBean(DoFieldMapper.class);
        Field[] fields = {new Field().setName("te1").setComment("test")};
        mapper.delTableField(new Table().setName("test").addFields(fields));
    }
}
