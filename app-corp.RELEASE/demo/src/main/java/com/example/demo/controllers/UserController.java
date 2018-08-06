package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {
	
	private UserService userservice;
	
	//login
    @PostMapping("login")
    @ResponseBody
    public Object login(@RequestParam("email") String email ,@RequestParam("password") String password) {		 	
    	System.out.println("out -------------------------------------------------------");
		 return userservice.login(email, password);
	 }
    
    
   //registration
    @Autowired
    public UserController(UserService userService) 
    {
    	this.userservice = userService;
    }
    
    @PostMapping("registration")
    @ResponseBody
    public Object regisration(@RequestParam("email") String email , @RequestParam("password")String password , @RequestParam("firstName")String firstName 
    		, @RequestParam("lastName")String lastName , @RequestParam("profilePic")String profilePic,@RequestParam("userTypeId") String userTypeId ) {
	return userservice.registration(firstName, lastName, email, password, profilePic, Integer.valueOf(userTypeId));
} 

}
 