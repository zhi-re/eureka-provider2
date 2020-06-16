package fun.chenqi.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author chenqi
 * @date 2019/7/15 10:01
 */
@RequestMapping("redisTest")
@RestController
public class RedisController {


//    @Autowired
//    private Redisson redisson;
    @Autowired
    private StringRedisTemplate redisTemplate;


//    @RequestMapping("redis")
//    public String redis() {
//        RLock lock = redisson.getLock("kkkey");
//        lock.lock(60, TimeUnit.SECONDS); //设置60秒自动释放锁  （默认是30秒自动过期）
//        System.out.println("provider------2-----");
//        System.out.println("provider--2----修改了库");
//        lock.unlock(); //释放锁
//        return "22222222222";
//    }

    @RequestMapping("redis2")
    public String redis2() {
        String key = "test123";
        //加锁
        DistributedRedisLock.acquire(key);
        System.out.println(System.currentTimeMillis());
        System.out.println("provider------2-----");
        System.out.println("provider--2----修改了库");
        //释放锁
        DistributedRedisLock.release(key);
        return "22222222222";
    }

    @RequestMapping("redis3")
    public String redis3() {
        redisTemplate.opsForValue().set("name", "chenqi");

        return redisTemplate.opsForValue().get("name").toString();
    }


}
