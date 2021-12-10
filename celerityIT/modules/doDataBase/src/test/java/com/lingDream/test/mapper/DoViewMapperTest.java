package com.lingDream.test.mapper;

import com.lingDream.DataBaseTestRun;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 关于数据视图的操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataBaseTestRun.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoViewMapperTest {
}
