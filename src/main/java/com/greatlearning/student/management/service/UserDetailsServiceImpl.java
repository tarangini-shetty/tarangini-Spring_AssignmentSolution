package com.greatlearning.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import com.greatlearning.library.management.entity.User;
import com.greatlearning.library.management.security.MyUserDetails;
import com.greatlearning.student.management.repository.UserRepository;



public class UserDetailsServiceImpl implements UserDetailsManager, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("Username" + username + "not found");
			
		}
		
		MyUserDetails myUserDetails = new MyUserDetails(user);
		return myUserDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
