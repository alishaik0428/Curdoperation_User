package com.restapiuser.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<UserEntity> getallusers()
	{
		return userepo.findAll();
	}
	
	 @PostMapping("/post")
	    public String createUser(@RequestBody UserEntity user) {
	       userepo.save(user);
	       return "New Is User  Created";
	    }
	 @GetMapping(value = "/get/{id}")
	 public Optional<UserEntity> getUser(@PathVariable Long id)
	 {
	     return userepo.findById(id);
	 }
	 
	 @DeleteMapping("/delete")
	 public String deleteuser()
	 {
		 userepo.deleteAll();
		 return "All Users are Deleted";
		 
	 }
	 @DeleteMapping("/delete/{id}")
	 public  String deletebyid(@PathVariable Long id)
	 {
//		 try {
//			 userepo.deleteById(id);
//		 }catch (Exception e) {
//			e.printStackTrace();
//		}
		 userepo.deleteById(id);
		return "User is Deleted Successfully";
	 }
	 
	 @PutMapping("/put/{id}")
	 public String updateuserid(@PathVariable Long id, @RequestBody UserEntity user)
	 {
		Optional<UserEntity> usr =userepo.findById(id);
		if(usr.isPresent())
		{
			UserEntity existusr = usr.get();
			existusr.setFirstName(user.getFirstName());
			existusr.setLastName(user.getLastName());
			existusr.setEmail(user.getEmail());
			existusr.setPassword(user.getPassword());
			userepo.save(existusr);
			return "User Id is "+ id +" updated";
		}
		else {
		return "User is not found "+id;
	 }
		
		
		
		
	 }

	  @GetMapping("/users/{id}")
//   public String getUserFirstNameById(@PathVariable Long id) {
//       return userService.getUserFirstNameById(id);
//   }
   public String getUserFirstNameById(@PathVariable Long id) {
       return userepo.findFirstNameByID(id);
   }
	
	  @GetMapping("/first")
	  public List<String> allFirstNames()
	  {
		  return userepo.fetchAllFirstNames();
	  }
	
	  @GetMapping("/first-last")
		public List<String> getAllFirstLastNames()
		{
			return userepo.getAllFirstLastNames();
		}
	
	  @GetMapping("/address/{address}")
	  public List<UserEntity> getUserByAddress(@PathVariable String address)
	  {
		  return userepo.getUserByAddress(address);
	  }
	 
	 

}



 




