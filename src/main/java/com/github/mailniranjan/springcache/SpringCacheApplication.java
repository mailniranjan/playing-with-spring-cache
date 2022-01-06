package com.github.mailniranjan.springcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringCacheApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringCacheApplication.class);

    @Autowired
    MyRepository myRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        int totalThreads = 5;
        final Thread[] threads = new Thread[totalThreads + 1];
        //CountDownLatch helps us to make sure that we can fire all the threads at the same time.
        final CountDownLatch countDownLatch = new CountDownLatch(totalThreads);

        for (int i = 1; i <= totalThreads; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    if (finalI % 2 == 0) {
                        myRepository.testReturningListOfLongs(1);
                    } else {
                        myRepository.testReturningListOfLongs(2);
                    }
                }
            });

            threads[i].start();
        }

        for (int i = 1; i <= totalThreads; i++) {
            threads[i].join();
        }
    }
}
