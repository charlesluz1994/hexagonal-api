package com.cluz.hex_client.adapters.out;

import com.cluz.hex_client.adapters.out.repository.CustomerRepository;
import com.cluz.hex_client.adapters.out.repository.mappers.CustomerEntityMapper;
import com.cluz.hex_client.application.core.domain.Customer;
import com.cluz.hex_client.application.ports.out.InsertCustomerOutputPort;
import com.cluz.hex_client.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public void updateCustomer(Customer customer) {
		var customerEntity = customerEntityMapper.toEntity(customer);
		customerRepository.save(customerEntity);
	}
}
