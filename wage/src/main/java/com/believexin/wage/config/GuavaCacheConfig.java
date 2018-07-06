package com.believexin.wage.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

/**
 * <p>Title: GuavaCacheConfig</p>
 * <p>Description: guava缓存配置</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年4月7日 下午9:15:04
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig {
	/**
     * 配置全局缓存参数，3600秒过期，最大个数1000
     */
    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3600, TimeUnit.SECONDS).maximumSize(1000));
        return cacheManager;
    }
}
