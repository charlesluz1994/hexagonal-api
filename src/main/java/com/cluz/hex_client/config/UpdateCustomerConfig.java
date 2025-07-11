package com.cluz.hex_client.config;

import com.cluz.hex_client.adapters.out.FindByAddressZipCodeAdapter;
import com.cluz.hex_client.adapters.out.UpdateCustomerAdapter;
import com.cluz.hex_client.application.core.usecase.FindCustomerByIdUseCase;
import com.cluz.hex_client.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

	@Bean
	public UpdateCustomerUseCase updateCustomerUseCase(
			UpdateCustomerAdapter updateCustomerAdapter,
			FindByAddressZipCodeAdapter findByAddressZipCodeAdapter,
			FindCustomerByIdUseCase findCustomerByIdUseCase
	) {
		return new UpdateCustomerUseCase(updateCustomerAdapter, findByAddressZipCodeAdapter, findCustomerByIdUseCase);
	}

}