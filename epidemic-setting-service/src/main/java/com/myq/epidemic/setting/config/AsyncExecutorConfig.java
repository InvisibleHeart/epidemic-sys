package com.myq.epidemic.setting.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Description: 多线程配置
 * @ClassName: AsyncExecutorConfig
 * @author: Wang Hong
 * @create: 2021/06/09
 */
@Configuration
@EnableAsync
public class AsyncExecutorConfig {

    private static final Logger Logger = LoggerFactory.getLogger(AsyncExecutorConfig.class);

    @Value("${executor.CorePoolSize}")
    private int corePoolSize;
    @Value("${executor.MaxPoolSize}")
    private int maxPoolSize;
    @Value("${executor.QueueCapacity}")
    private int queueCapacity;
    @Value("${executor.KeepAliveSeconds}")
    private int keepAliveSeconds;
    @Value("${executor.ThreadNamePrefix}")
    private String threadNamePrefix;


    // 声明一个线程池(并指定线程池的名字)
    @Bean("createTemplate")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数：线程池创建时候初始化的线程数
        executor.setCorePoolSize(corePoolSize);
        //最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大
        executor.setQueueCapacity(queueCapacity);
        //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
//        #线程最大空闲时间 ,默认3000
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //线程池名的前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        //执行初始化
        executor.initialize();
        return executor;
    }

}
