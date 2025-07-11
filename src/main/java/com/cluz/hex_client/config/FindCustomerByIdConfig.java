package com.cluz.hex_client.config;

import com.cluz.hex_client.adapters.out.FindCustomerByIdAdapter;
import com.cluz.hex_client.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

	@Bean
	public FindCustomerByIdUseCase findCustomerByIdUseCase(
			FindCustomerByIdAdapter findCustomerByIdAdapter
	) {
		return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
	}

}