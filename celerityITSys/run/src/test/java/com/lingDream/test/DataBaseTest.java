package com.lingDream.test;

import com.lingDream.CelerityITApplication;
import com.lingDream.celerityIT.service.DoDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ChenXiHua
 * @desciption 用户管理测试类
 * @date 2019年2月19日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CelerityITApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataBaseTest {
    @Autowired
    DoDataService doDataService;

    @Test
    public void ff() {
        System.out.println(doDataService);
    }
}
