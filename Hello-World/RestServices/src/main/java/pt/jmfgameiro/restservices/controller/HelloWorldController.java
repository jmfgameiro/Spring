package pt.jmfgameiro.restservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/hello" )
public class HelloWorldController {
	
	
	@RequestMapping( value = "/world", method = RequestMethod.GET )
	public String simple() {
		return "hello";
	}
	
	
	
}
