package ysw;

import demo.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/8 21:41
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
        Test test1 = (Test)context.getBean("test1");
        System.out.println(test1);
    }
}
