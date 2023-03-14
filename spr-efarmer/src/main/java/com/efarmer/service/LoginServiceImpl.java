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
		Login cUser=loginDao.checkUser(user.getEmail(),user.getPassword());
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
	
	

}
