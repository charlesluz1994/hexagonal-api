package com.cluz.hex_client.application.ports.in;

import com.cluz.hex_client.application.core.domain.Customer;

public interface InsertCustomerInputPort {
	void insertCustomer(Customer customer, String zipCode);

}
