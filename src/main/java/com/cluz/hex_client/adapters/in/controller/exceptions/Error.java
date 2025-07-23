package com.cluz.hex_client.adapters.in.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class Error {

	private ZonedDateTime dateTime;
	private Integer status;
	private String message;
	private String path;

}
