package com.cluz.hex_client.adapters.out;

import com.cluz.hex_client.adapters.out.client.FindAddressByZipCodeClient;
import com.cluz.hex_client.adapters.out.client.mappers.AddressMapper;
import com.cluz.hex_client.application.core.domain.Address;
import com.cluz.hex_client.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByAddressZipCodeAdapter implements FindAddressByZipCodeOutputPort {

	private final FindAddressByZipCodeClient findAddressByZipCodeClient;
	private final AddressMapper addressMapper;

	@Override
	public Address find(String zipCode) {
		var addressResponse = findAddressByZipCodeClient.find(zipCode);

		return addressMapper.toAddress(addressResponse);
	}
}
