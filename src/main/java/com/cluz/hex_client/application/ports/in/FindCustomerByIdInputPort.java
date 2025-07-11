package com.cluz.hex_client.application.ports.in;

import com.cluz.hex_client.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
	Customer findCustomerById(String id);

}
