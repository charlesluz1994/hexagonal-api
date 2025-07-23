package com.cluz.hex_client.application.core.usecase;

import com.cluz.hex_client.application.core.domain.Customer;
import com.cluz.hex_client.application.core.exceptions.CustomerNotFoundException;
import com.cluz.hex_client.application.ports.in.FindCustomerByIdInputPort;
import com.cluz.hex_client.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {


	private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

	public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
		this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
	}

	@Override
	public Customer findCustomerById(String id) {
		return findCustomerByIdOutputPort.findCustomerById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
	}
}
