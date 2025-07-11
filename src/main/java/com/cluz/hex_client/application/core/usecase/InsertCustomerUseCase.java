package com.cluz.hex_client.application.core.usecase;

import com.cluz.hex_client.application.core.domain.Customer;
import com.cluz.hex_client.application.ports.in.InsertCustomerInputPort;
import com.cluz.hex_client.application.ports.out.FindAddressByZipCodeOutputPort;
import com.cluz.hex_client.application.ports.out.InsertCustomerOutputPort;
import com.cluz.hex_client.application.ports.out.SendCpfToValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

	private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
	private final InsertCustomerOutputPort insertCustomerOutputPort;

	private final SendCpfToValidationOutputPort sendCpfToValidationOutputPort;

	public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
								 InsertCustomerOutputPort insertCustomerOutputPort, SendCpfToValidationOutputPort sendCpfToValidationOutputPort) {
		this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
		this.sendCpfToValidationOutputPort = sendCpfToValidationOutputPort;
	}

	@Override
	public void insertCustomer(Customer customer, String zipCode) {
		//Connect to the cpf app, through an interface output port.
		var address = findAddressByZipCodeOutputPort.find(zipCode);
		/*if (address == null) {throw new IllegalArgumentException("Address not found for zip code: " + zipCode);}*/
		customer.setAddress(address);
		insertCustomerOutputPort.insertCustomer(customer);
		sendCpfToValidationOutputPort.sendCpfToValidation(customer.getCpf());

	}

}
