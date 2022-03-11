package ysw;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author yunshuaiwei
 * @className RedisTest
 * @description: TODO
 * @date 2022/3/11 10:03
 */
public class RedisTest {

    private RedisTemplate redisTemplate;


    public void testLock(){

        //获取锁
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "11",5, TimeUnit.SECONDS);

        if (lock){//获取锁成功
            //获取值
            Object value = redisTemplate.opsForValue().get("num");
            if (StringUtils.isEmpty(value)){
                return;
            }
            //将值转为int
            int num = Integer.parseInt(value + "");
            //操作数据
            redisTemplate.opsForValue().set("num",++num);
            //释放锁
            redisTemplate.delete("lock");
        }else{//获取锁失败
            try {
                //间隔0.1s重新获取锁
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
