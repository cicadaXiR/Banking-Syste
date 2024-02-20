package com.myproject.mybankingsystem.authentication;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDto> getUserInfo(String email){
		Optional<User> userdata = userRepository.findByEmail(email);
		return userdata.stream().map(user ->{
			UserDto userdto = new UserDto();
			userdto.setFirstName(user.getFirstName());
			userdto.setLastName(user.getLastName());
			return userdto;
		}).collect(Collectors.toList());
	}
}
