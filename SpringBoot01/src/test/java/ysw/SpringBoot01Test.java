package ysw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ysw.controller.User;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/5 11:13
 * @Version
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01Test {

    @Autowired
    User user;
    @Test
    public void contextLoads(){
        System.out.println(user.toString());
    }

}
