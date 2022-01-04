package com.github.mailniranjan.springcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		logger.info("In run method");
		myRepository.testReturningListOfLongs(1);
		myRepository.testReturningListOfLongs(1);
		myRepository.testReturningListOfLongs(1);
		myRepository.testReturningListOfLongs(2);
		myRepository.testReturningListOfLongs(2);
	}
}
