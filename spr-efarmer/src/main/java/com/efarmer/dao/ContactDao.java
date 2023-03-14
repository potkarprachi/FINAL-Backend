package com.efarmer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efarmer.model.ContactUs;

public interface ContactDao  extends JpaRepository<ContactUs, Integer>{

}
