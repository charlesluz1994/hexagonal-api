package com.cluz.hex_client.adapters.out.client.mapper;

import com.cluz.hex_client.adapters.out.client.response.AddressResponse;
import com.cluz.hex_client.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	Address toAddress(AddressResponse addressResponse);
}
