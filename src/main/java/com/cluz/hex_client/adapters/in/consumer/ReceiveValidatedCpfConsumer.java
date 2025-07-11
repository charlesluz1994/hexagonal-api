package com.cluz.hex_client.adapters.in.consumer;

import com.cluz.hex_client.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.cluz.hex_client.adapters.in.consumer.message.CustomerMessage;
import com.cluz.hex_client.application.ports.in.UpdateCustomerInputPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

	private final UpdateCustomerInputPort updateCustomerInputPort;
	private final CustomerMessageMapper messageMapper;


	public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort, CustomerMessageMapper messageMapper) {
		this.updateCustomerInputPort = updateCustomerInputPort;
		this.messageMapper = messageMapper;
	}

	@KafkaListener(topics = "${kafka.topic.validated-cpf}", groupId = "cluz")
	public void receiveValidatedCpf(CustomerMessage customerMessage){
		var customer = messageMapper.toCustomer(customerMessage);
		updateCustomerInputPort.updateCustomer(customer, customerMessage.getZipCode());
	}
}
