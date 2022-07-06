package com.fundatec.bancoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
public class BancoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApiApplication.class, args);
	}

}
