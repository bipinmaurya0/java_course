package com.restApiForTesting.restFullApiwebservices;

import java.time.LocalDateTime;

public class ErroException {
	private LocalDateTime locatedate;
	private String message;
	private String details;

	public ErroException(LocalDateTime localdate, String message, String details) {
		super();
		this.locatedate = localdate;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getLocatedate() {
		return locatedate;
	}
	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
