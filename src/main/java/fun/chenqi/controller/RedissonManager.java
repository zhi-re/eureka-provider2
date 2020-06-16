package fun.chenqi.controller;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author chenqi
 * @date 2019/7/15 9:47
 */
@Configuration
public class RedissonManager {

    private static Config config = new Config();
    //声明redission对象
    private static Redisson redisson = null;

    //实例化redisson
    static {
        config.useSingleServer().setAddress("127.0.0.1:6379");
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);

    }

    //获取redisson对象的方法
    public static Redisson getRedisson() {
        return redisson;
    }


//    @Bean
//    Redisson redissonSentinel() {
//        Config config = new Config();
//        config.useClusterServers()
//                .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
//                //可以用"redis://"来启用SSL连接
//                .addNodeAddress("redis://127.0.0.1:6379");
//        return (Redisson) Redisson.create(config);
//    }
//

//    /**
//     * redisson客户端集集群配置
//     * @return
//     * @throws IOException
//     */
//    @Bean(destroyMethod = "shutdown")
//    public RedissonClient redissonClient() throws IOException {
//        Config config = Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream());
//        return Redisson.create(config);
//    }
}
