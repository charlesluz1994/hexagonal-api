package com.cluz.hex_client.adapters.in.controller.mapper;

import com.cluz.hex_client.adapters.in.controller.request.CustomerRequest;
import com.cluz.hex_client.adapters.in.controller.response.CustomerResponse;
import com.cluz.hex_client.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	Customer toCustomer(CustomerRequest customerRequest);

	CustomerResponse toCustomerResponse(Customer customer);
}
