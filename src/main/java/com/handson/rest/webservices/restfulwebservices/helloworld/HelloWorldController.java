package com.handson.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("helloworld")
	public String helloWorld()
	{
		return "Hello World!";
	}
		
	@GetMapping("helloworldbean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World from bean!");
	}
	
	@GetMapping("helloworldinternationalized")
	public String helloWorldInternationalized(
			@RequestHeader(name="Accept-Language", required=false) Locale locale )
	{
		return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
	}
	
}
