package com.security.oauth2ResourceServer.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {

	@GetMapping
	public String test() {
		return "OK";
	}
	
	@GetMapping(path="/hello",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasRole('ROLE_VIEWER')")
	public String test2() {
		return "OK";
	}
	
	@GetMapping(path="/helloAdmin",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String test3(OAuth2Authentication auth) {
		return "Hello "+auth.getUserAuthentication().getName();
//		return "OK";
	}
	

}
