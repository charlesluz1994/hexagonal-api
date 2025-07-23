package com.cluz.hex_client.application.core.exceptions;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(final String id){
		super("Customer with id: " + id + " not found.");
	}
}
