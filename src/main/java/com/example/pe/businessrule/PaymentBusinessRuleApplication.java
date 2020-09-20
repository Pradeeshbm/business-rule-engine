package com.example.pe.businessrule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentBusinessRuleApplication implements ApplicationRunner {
	
	@Autowired
	private PaymentProcessorExample example;

	public static void main(String[] args) {
		SpringApplication.run(PaymentBusinessRuleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		example.test();
	}

}
