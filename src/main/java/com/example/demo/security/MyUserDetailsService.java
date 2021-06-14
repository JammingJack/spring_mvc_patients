/*
package com.example.demo.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MyUserDetails;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = Optional.of(userRepository.findByUsername(username));
		user.orElseThrow(()->new UsernameNotFoundException("no user found with the name " + username));
		
		return user.map(MyUserDetails::new).get();
	}

}
*/