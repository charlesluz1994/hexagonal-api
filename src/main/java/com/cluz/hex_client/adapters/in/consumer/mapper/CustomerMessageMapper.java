package com.cluz.hex_client.adapters.in.consumer.mapper;

import com.cluz.hex_client.adapters.in.consumer.message.CustomerMessage;
import com.cluz.hex_client.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

	@Mapping(target="address", ignore = true)
	Customer toCustomer(CustomerMessage customerMessage);
}
