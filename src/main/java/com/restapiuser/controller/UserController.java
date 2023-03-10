package com.restapiuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.restapiuser.model.UserEntity;
import com.restapiuser.repository.UserRepository;

@RestController
@RequestMapping("/top")
public class UserController {
	@Autowired
	UserRepository userepo;
	
	@RequestMapping("/start")
	public String start()
	{
		return "You are in Main User";
	}
	
	@GetMapping("/get")
	public List<UserEntity> getallus()
	{
		return userepo.findAll();
	}
	
	 @PostMapping("/post")
	    public String createUser(@RequestBody UserEntity user) {
	       userepo.save(user);
	       return "User Is Created";
	    }

}
