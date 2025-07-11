package com.cluz.hex_client.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
@Data
public class AddressEntity {
	private String street;
	private String city;
	private String state;
}
