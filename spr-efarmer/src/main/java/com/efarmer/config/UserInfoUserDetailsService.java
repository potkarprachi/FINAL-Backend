package com.efarmer.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.efarmer.dao.LoginDao;
import com.efarmer.model.Login;

@Service
@Transactional
public class UserInfoUserDetailsService implements UserDetailsService
{
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{	
		System.out.println("userinfoservice"+email);
		Optional<Login> user=loginDao.findByEmail(email);
		System.out.println("after userinfoservice"+user);
		
		//Login user = ( loginDao.checkUserByEmail(email)).orElseThrow(()->new UsernameNotFoundException("Invalid Email id"));
	
		
		return new UserInfoUserDetails(user.get()); 
	}
	
	
}
