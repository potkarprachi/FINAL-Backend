package com.efarmer.config;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.efarmer.model.Login;

public class UserInfoUserDetails implements UserDetails
{
private Login user;
	
	
	public UserInfoUserDetails (Login user)
	{
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		HashSet<GrantedAuthority> set = new HashSet<GrantedAuthority>();
		if(user.getRole().equals("farmer"))
		{
			set.add(new GrantedAuthority() {

				@Override
				public String getAuthority() {
					return "Farmer";
				}
			});
		}else if(user.getRole().equals("customer"))
		{
			set.add(new GrantedAuthority() {

				@Override
				public String getAuthority() {
					return "Customer";
				}
			});
		}else
		{
			set.add(new GrantedAuthority() {

				@Override
				public String getAuthority() {
					return "Adming";
				}
			});
		}
		return set;
	}

	@Override
	public String getPassword()
	{
		
		return user.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
	
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}
}
