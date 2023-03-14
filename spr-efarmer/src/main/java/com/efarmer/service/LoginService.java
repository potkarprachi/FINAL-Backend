package com.efarmer.service;

import com.efarmer.model.Login;

public interface LoginService 
{
	void insert(Login user);
	Login check(Login user);
	Login getDetails(int id);
	Login update(Login user);
	Login getDetailsByEmail(String email);
}
