package com.github.mailniranjan.springcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Cacheable(value="testCache", key = "#input")
    @Cacheable(value = "testCache", key = "#input", sync = true)
    public List<Long> testReturningListOfLongs(int input)
    {
        logger.info("Inside the method for: " + input);
        return Arrays.asList(1L, 2L, 3L);
    }
}
