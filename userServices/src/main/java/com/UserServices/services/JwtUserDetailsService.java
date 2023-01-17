package com.UserServices.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.UserServices.models.UserInfo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	  @Autowired
	  UserServices userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
	
		 Optional<UserInfo> user = userService.findUser(username);
			
			if (null != user) {
				Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_" + user.get().getRole()));
				return new User(user.get().getUserName(), user.get().getPassword(), authorities);
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		} 
	
}