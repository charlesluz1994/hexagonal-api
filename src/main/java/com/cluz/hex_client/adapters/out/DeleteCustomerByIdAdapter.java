package com.cluz.hex_client.adapters.out;

import com.cluz.hex_client.adapters.out.repository.CustomerRepository;
import com.cluz.hex_client.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

	private final CustomerRepository customerRepository;

	@Override
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}
}
