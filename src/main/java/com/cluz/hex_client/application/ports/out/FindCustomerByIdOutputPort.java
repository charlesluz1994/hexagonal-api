package com.cluz.hex_client.application.ports.out;

import com.cluz.hex_client.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

	Optional<Customer> findCustomerById(String id);
}
