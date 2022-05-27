package com.myq.epidemic.setting.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @Author 毛一钦
 * @Date 2022/3/3 17:44
 **/
@Configurable
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.database}")
    private int redisDatabase;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);
        configuration.setDatabase(redisDatabase);
        return new LettuceConnectionFactory(configuration);
    }

    //  自定的一个redisTemplate
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        //  JSON序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //  指定序列化输入类型
        //  om.enableDefaultTyping()该方法已过期 存在高危漏洞
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //  String 的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //  key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        //  hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        //  value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //  hash的value序列化也采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Override
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new SimpleCacheErrorHandler();
    }

    @Primary
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisSerializationContext.SerializationPair<Object> serializationPair =
                RedisSerializationContext.SerializationPair.fromSerializer(new GenericFastJsonRedisSerializer());
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(30))
                .serializeValuesWith(serializationPair);
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    
//    private Map<String, RedisCacheConfiguration> generateCacheConfigMap() {
//        //  针对不同的cacheName，设置不同的过期时间
//        HashMap<String, RedisCacheConfiguration> initialCacheConfiguration = new HashMap<>();
//        initialCacheConfiguration.put("", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)));
//        return initialCacheConfiguration;
//    }


}
