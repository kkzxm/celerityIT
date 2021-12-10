package com.lingDream.test.service;

import com.lingDream.DataBaseTestRun;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 操作数据的Service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataBaseTestRun.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoDataServiceTest {
}
