package com.diegolirio.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@ComponentScan(basePackages= {"com.diegolirio.st"})
@SpringBootApplication
public class StPurchaseOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(StPurchaseOrderApplication.class, args);
	}
}
