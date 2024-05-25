package com.restApiForTesting.restFullApiwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String getData() {
		
		return "hello world Find Me";
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean getDataBean() {
		
		return new HelloWorldBean("hello world Please check value");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean getDataForPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean("hello world ,"+name);
	}

}
