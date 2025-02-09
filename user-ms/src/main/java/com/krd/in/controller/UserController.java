package com.krd.in.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Value("${msg}")
	private String message;

	@GetMapping("/test")
	public String getTest() {
		return "user-ms working properly "+message;
	}
}
