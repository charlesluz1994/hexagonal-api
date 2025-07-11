package com.cluz.hex_client.adapters.in.controller;

import com.cluz.hex_client.adapters.in.controller.mapper.CustomerMapper;
import com.cluz.hex_client.adapters.in.controller.request.CustomerRequest;
import com.cluz.hex_client.adapters.in.controller.response.CustomerResponse;
import com.cluz.hex_client.application.ports.in.DeleteCustomerByIdInputPort;
import com.cluz.hex_client.application.ports.in.FindCustomerByIdInputPort;
import com.cluz.hex_client.application.ports.in.InsertCustomerInputPort;
import com.cluz.hex_client.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final InsertCustomerInputPort insertCustomerInputPort;
	private final FindCustomerByIdInputPort findCustomerByIdInputPort;
	private final UpdateCustomerInputPort updateCustomerInputPort;
	private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

	private final CustomerMapper customerMapper;

	@PostMapping()
	public ResponseEntity<Void> saveCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
		var customer = customerMapper.toCustomer(customerRequest);

		insertCustomerInputPort.insertCustomer(customer, customerRequest.getZipCode());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable final String id) {

		var customer = findCustomerByIdInputPort.findCustomerById(id);
		var customerResponse = customerMapper.toCustomerResponse(customer);

		return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateCustomer(@PathVariable final String id,
														   @Valid @RequestBody CustomerRequest customerRequest) {

		var customer = customerMapper.toCustomer(customerRequest);
		customer.setId(id);
		updateCustomerInputPort.updateCustomer(customer, customerRequest.getZipCode());
		//customerMapper.toCustomerResponse(customer);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable final String id) {

		deleteCustomerByIdInputPort.deleteCustomer(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
