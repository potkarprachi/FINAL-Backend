package com.efarmer.cntr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.efarmer.model.Login;
import com.efarmer.service.JwtService;
import com.efarmer.service.LoginService;



@RestController
@CrossOrigin(value= {"http://localhost:3000"})
public class LoginController 
{
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value= {"/userAdd"})
	public String userAdd(@RequestBody Login user)
	{
		loginService.insert(user);
		return "success";
	}
	
//	@GetMapping(value= {"/userAddGet"})
//	public String userAddGet(Login user)
//	{
//		loginService.insert(user);
//		return "success";
//	}
	
	@PostMapping(value= {"/userLogin1"})
	public Login userLogin(@RequestBody Login user)
	{	
		//String username=user.getEmail();
		//return jwtService.generateToken(username);
		return loginService.check(user);
	}
	
	@GetMapping(value= {"/getAccDetails/{id}"})
	public Login getAccDetailsId(@PathVariable int id)
	{
		return loginService.getDetails(id);
	}

	@GetMapping(value= {"/getAccDetailbyemail/{email}"})
	public Login getAccDetailsEmail(@PathVariable String email)
	{	
		return loginService.getDetailsByEmail(email);
	}
	
	@PutMapping(value= {"/updateAccDetails"})
	public Login getAccDetailsId(@RequestBody Login user)
	{
		System.out.println(user);
		return loginService.update(user);
	}
	
	@PostMapping("/userLogin")
	public String authenticateAndGetToken(@RequestBody Login user)
	{	
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(user.getEmail());
		}
		else
		{
			throw new UsernameNotFoundException("Invalid Credentials");
		}
		/*
		String username=user.getEmail();
		System.out.println("inside controller"+username);*/
		
	}
}


//prachi
//akshay1