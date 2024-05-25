package com.restApiForTesting.restFullApiwebservices;

public class HelloWorldBean{
	
	private String message;

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String str)
	{
		this.message=str;
	}


}
