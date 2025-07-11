package com.cluz.hex_client.adapters.out;

import com.cluz.hex_client.adapters.out.repository.CustomerRepository;
import com.cluz.hex_client.adapters.out.repository.mappers.CustomerEntityMapper;
import com.cluz.hex_client.application.core.domain.Customer;
import com.cluz.hex_client.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public Optional<Customer> findCustomerById(String id) {
		return customerRepository.findById(id)
				.map(customerEntityMapper::toCustomer);
	}
}
