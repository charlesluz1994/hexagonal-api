package com.cluz.hex_client.adapters.in.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Error {

	private ZonedDateTime dateTime;
	private Integer status;
	private String message;
	private String path;

}
