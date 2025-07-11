package com.cluz.hex_client.config;

import com.cluz.hex_client.adapters.out.DeleteCustomerByIdAdapter;
import com.cluz.hex_client.application.core.usecase.DeleteCustomerByIdByIdUseCase;
import com.cluz.hex_client.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

	@Bean
	public DeleteCustomerByIdByIdUseCase deleteCustomerUseCase(
			DeleteCustomerByIdAdapter deleteCustomerByIdAdapter,
			FindCustomerByIdUseCase findCustomerByIdUseCase
	) {
		return new DeleteCustomerByIdByIdUseCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
	}

}