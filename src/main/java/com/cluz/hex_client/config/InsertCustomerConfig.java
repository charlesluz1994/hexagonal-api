package com.cluz.hex_client.config;

import com.cluz.hex_client.adapters.out.FindByAddressZipCodeAdapter;
import com.cluz.hex_client.adapters.out.InsertCustomerAdapter;
import com.cluz.hex_client.adapters.out.SendCpfValidationAdapter;
import com.cluz.hex_client.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

	@Bean
	public InsertCustomerUseCase insertCustomerUseCase(
			FindByAddressZipCodeAdapter findByAddressZipCodeAdapter,
			InsertCustomerAdapter insertCustomerAdapter,
			SendCpfValidationAdapter sendCpfValidationAdapter

	) {
		return new InsertCustomerUseCase(findByAddressZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
	}
}