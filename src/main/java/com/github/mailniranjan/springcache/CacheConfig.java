package com.github.mailniranjan.springcache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.NamedCacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

//    @Bean
//    CacheResolver cacheResolver()
//    {
//        return new NamedCacheResolver();
//    }

}
