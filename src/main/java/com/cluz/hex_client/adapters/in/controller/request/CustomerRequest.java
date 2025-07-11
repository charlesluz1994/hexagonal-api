package com.cluz.hex_client.adapters.in.controller.request;

import jakarta.validation.Valid;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CustomerRequest{
	@Valid
	private String name;

	@Valid
	@CPF
	private String cpf;

	@Valid
	private String zipCode;
}
