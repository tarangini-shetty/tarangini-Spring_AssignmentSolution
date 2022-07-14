package com.greatlearning.student.management.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	
	public UserDetails loadUserByUsername(String username);

}