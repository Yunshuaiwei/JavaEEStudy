package ysw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author yunshuaiwei
 * @className RedisTest
 * @description: TODO
 * @date 2022/3/11 10:03
 */
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @author yunshuaiwei
     * @description 分布式锁测试
     * @date 10:24 2022/3/11
     * @Param []
     * @Return void
     */
    public void testLock() {
        String uuid = UUID.randomUUID().toString();
        //获取锁
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 5, TimeUnit.SECONDS);
        if (lock) {//获取锁成功
            //获取值
            Object value = redisTemplate.opsForValue().get("num");
            if (StringUtils.isEmpty(value)) {
                return;
            }
            //将值转为int
            int num = Integer.parseInt(value + "");
            //操作数据
            redisTemplate.opsForValue().set("num", ++num);
            //释放锁
            String lockUUID = (String) redisTemplate.opsForValue().get("lock");
            if (lockUUID.equals(uuid)) {
                redisTemplate.delete("lock");
            }
        } else {//获取锁失败
            try {
                //间隔0.1s重新获取锁
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
