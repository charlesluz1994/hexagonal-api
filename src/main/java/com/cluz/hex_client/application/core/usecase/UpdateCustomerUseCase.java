package com.cluz.hex_client.application.core.usecase;

import com.cluz.hex_client.application.core.domain.Customer;
import com.cluz.hex_client.application.ports.in.FindCustomerByIdInputPort;
import com.cluz.hex_client.application.ports.in.UpdateCustomerInputPort;
import com.cluz.hex_client.application.ports.out.FindAddressByZipCodeOutputPort;
import com.cluz.hex_client.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;

	private final UpdateCustomerOutputPort updateCustomerOutputPort;
	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

	public UpdateCustomerUseCase(UpdateCustomerOutputPort updateCustomerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
		this.updateCustomerOutputPort = updateCustomerOutputPort;
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
	}

	@Override
	public void updateCustomer(Customer customer, String zipCode) {
		findCustomerByIdInputPort.findCustomerById(customer.getId());
		var addressFound = findAddressByZipCodeOutputPort.find(zipCode);

		customer.setAddress(addressFound);

		updateCustomerOutputPort.updateCustomer(customer);
	}
}
