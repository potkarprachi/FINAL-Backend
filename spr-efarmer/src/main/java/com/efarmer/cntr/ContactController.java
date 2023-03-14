package com.efarmer.cntr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efarmer.PDto.contactDto;
import com.efarmer.service.ContactService;

@RestController
@CrossOrigin(value= {"http://localhost:3000"})
public class ContactController{
	
	
	 ContactService contactservice;
     @Autowired
	 public ContactController(ContactService contactservice){
		this.contactservice = contactservice;
	}
     
     @PostMapping("/userquery")
     public String createPost(@RequestBody contactDto contactdto)
     {
    	  contactservice.createQuery(contactdto);
         return "Success";
     }
     
     @GetMapping("/getqueries")
     public List<contactDto> GetPost()
     {
    	 List<contactDto> cd  = new ArrayList<>();
         cd = contactservice.GetPost();
    	 return cd;
     }
     
     
     
     
     
     
     
}
