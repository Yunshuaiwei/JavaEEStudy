package com.example.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/13 12:23
 */
@SpringBootTest
public class PropertiesTest {


    @Value("${test.properties}")
    private String value;
    @Test
    void testProperties(){
        System.out.println(value);
    }
}
