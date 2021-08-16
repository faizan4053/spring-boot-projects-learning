package com.eldorado.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eldorado.authservice.models.AuthUser;
import com.eldorado.authservice.repository.UserRepository;

/*
 * Class UserDetailsServiceImpl is implements UserDetailsService and
 * overriding loadUserByUsername() method to provide custom user credentials
 * like UserNname and Password along with user role
 * 
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	/*
	 * Injecting dependency for UserRepository
	 */
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * 
	 * Return Type:UserDetails
	 * Value : User Object
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*
		 * Calling method findByEmail to fetch User for corresponding username
		 */
		
		AuthUser user = userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User is not present !");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getRoles());
	}

}
