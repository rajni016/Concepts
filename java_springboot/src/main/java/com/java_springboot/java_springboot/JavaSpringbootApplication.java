package com.java_springboot.java_springboot;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.spring.starter.embedded.InfinispanCacheConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

//for the first time for spring boot project main class has to be run
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class JavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringbootApplication.class, args);
	}

		@Bean // is a pojo class  for the configuration purposes
		public InfinispanCacheConfigurer cacheConfigurer() {
			return manager -> {
				final Configuration ispnConfig = new ConfigurationBuilder().clustering().cacheMode(CacheMode.LOCAL).build();
				manager.defineConfiguration("local-cache", ispnConfig);
			};
		}

	}

