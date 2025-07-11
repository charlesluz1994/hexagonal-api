package com.cluz.hex_client.application.core.usecase;

import com.cluz.hex_client.application.ports.in.DeleteCustomerByIdInputPort;
import com.cluz.hex_client.application.ports.in.FindCustomerByIdInputPort;
import com.cluz.hex_client.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdByIdUseCase implements DeleteCustomerByIdInputPort {

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;

	private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

	public DeleteCustomerByIdByIdUseCase(DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
		this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
	}

	@Override
	public void deleteCustomer(String id) {
		findCustomerByIdInputPort.findCustomerById(id);
		deleteCustomerByIdOutputPort.deleteCustomer(id);
	}
}
