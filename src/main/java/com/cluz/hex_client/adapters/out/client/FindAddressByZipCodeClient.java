package com.cluz.hex_client.adapters.out.client;

import com.cluz.hex_client.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "findAddressByZipCodeClient", url = "${cluz.client.address.url}")
public interface FindAddressByZipCodeClient {

	@GetMapping("/addresses/{zipCode}")
	AddressResponse find(@PathVariable("zipCode") String zipCode);
}
