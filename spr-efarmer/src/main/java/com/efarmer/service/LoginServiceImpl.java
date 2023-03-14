package com.efarmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.efarmer.dao.LoginDao;
import com.efarmer.model.Login;



@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void insert(Login user) 
	{	
		System.out.println(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		loginDao.save(user);
		
	}

	@Override
	public Login check(Login user) 
	{
		Login cUser=loginDao.checkUser(user.getEmail());
			return cUser;
	}
	
	@Override
	public Login getDetails(int id)
	{
		Login cUser=loginDao.getInfo(id);
		return cUser;
	}
	@Override
	public Login update(Login user) 
	{	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Login cUser=loginDao.save(user);
		return cUser;
		
	}

	@Override
	public Login getDetailsByEmail(String email) {
		
		Login cUser=loginDao.getInfoByEmail(email);
		return cUser;
	}
	
	@Override
	public String passwordUpdate(String email,String password) {

		 Login	cUsertemp  = loginDao.checkUser(email);
		 System.out.println(cUsertemp.getPassword());
		 System.out.println(cUsertemp.getEmail());
		 cUsertemp.setPassword(passwordEncoder.encode(password));
		 System.out.println(cUsertemp.getPassword());
		 loginDao.save(cUsertemp);
		 return "success";
		       
	}

	@Override
	public Login checkEmail(String email) {
		Login cUser = loginDao.checkEmail(email);
		return cUser;
	}
	
	

}
