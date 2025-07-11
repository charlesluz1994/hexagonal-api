package com.cluz.hex_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HexClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexClientApplication.class, args);
	}

}
