package com.cluz.hex_client.adapters.out;

import com.cluz.hex_client.application.ports.out.SendCpfToValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCpfValidationAdapter implements SendCpfToValidationOutputPort {


	@Value("${kafka.topic.validation-cpf}")
	private String topicCpfValidation;

	private final KafkaTemplate<String, String> kafkaTemplate;
	@Override
	public void sendCpfToValidation(String cpf) {
		kafkaTemplate.send(topicCpfValidation, cpf);
	}
}
