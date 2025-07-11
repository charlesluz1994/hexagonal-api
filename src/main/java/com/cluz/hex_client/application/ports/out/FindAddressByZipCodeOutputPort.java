package com.cluz.hex_client.application.ports.out;

import com.cluz.hex_client.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

	Address find(String zipCode);
}
