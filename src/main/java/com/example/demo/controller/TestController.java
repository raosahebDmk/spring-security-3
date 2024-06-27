package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/home")
	public String handleWelcome()
	{
		return "home...............";
	}
	
	@GetMapping("/admin/home")
	public String handleAdmin()
	{
		return "Admin Home Page";
	}
	
	@GetMapping("/user/home")
	public String handleUser()
	{
		return "User Home Page";
	}
}
