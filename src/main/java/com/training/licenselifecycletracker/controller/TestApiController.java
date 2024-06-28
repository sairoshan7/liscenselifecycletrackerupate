package com.training.licenselifecycletracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@CrossOrigin("*")
@RequestMapping("/api/test")
public class TestApiController {
 
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	@GetMapping("/user")
	public String userAccess() {
		return "User Content.";
	}
 
	@GetMapping("/mod")
	public String parentAccess() {
		return "Moderator Board.";
	}
	
	@GetMapping("/technicalsupport")
	public String technicalSupportAccess() {
		return "Technical Support Board.";
	}
 
	@GetMapping("/admin")
	public String adminAccess() {
		return "Admin Board.";
	}
}