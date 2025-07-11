package com.cluz.hex_client.application.ports.out;

import com.cluz.hex_client.application.core.domain.Customer;

public interface DeleteCustomerByIdOutputPort {

	void deleteCustomer(String id);
}
