package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	List<User> fakeUsers=List.of(
				new User(1231L,"Mohammad Faizan","7357444910"),
				new User(1232L,"Rahul Tuteja","8575689545"),
				new User(1233L,"Dixit Jain","7357444523"),
				new User(1234L,"Yashvendar","7857444910"),
				new User(1235L,"Aakash Gopals","73458444910")
			);

	
	@Override
	public User getUser(Long id) {
		
		User user=fakeUsers
				.stream()
				.filter(u -> u.getId().equals(id))
				.findAny()
				.orElse(null);

		return user;
	}

}
