package org.example;

import org.config.SpringConfig;
import org.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserServiceImpl userServiceImpl = context.getBean(UserServiceImpl.class);
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        System.out.println(dataSource);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.show();


    }
}