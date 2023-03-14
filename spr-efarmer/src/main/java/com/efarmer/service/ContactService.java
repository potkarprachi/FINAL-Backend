package com.efarmer.service;

import java.util.List;

import com.efarmer.PDto.contactDto;

public interface ContactService {

	contactDto createQuery(contactDto contactdto);
    
	    List< contactDto> GetPost();
	}


