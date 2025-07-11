package com.cluz.hex_client.adapters.out.repository.mappers;

import com.cluz.hex_client.adapters.out.repository.entity.CustomerEntity;
import com.cluz.hex_client.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

	CustomerEntity toEntity(Customer customer);

	Customer toCustomer(CustomerEntity customerEntity);

}