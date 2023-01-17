package com.UserServices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserServices.Repository.UserRepository;
import com.UserServices.execptions.UserExceptions;
import com.UserServices.models.UserInfo;

@Service
public class UserServices {

	@Autowired
	UserRepository userRepo;

	public String addUser(UserInfo user) 
	 {
		 userRepo.save(user);
		 return "You are sucessfully Registered Please login ";
		 
	 }
	public String updateUser(UserInfo user) throws UserExceptions
	{
		if(userRepo.findById(user.getUserId()).isPresent())
		{
			userRepo.deleteById(user.getUserId());
			userRepo.save(user);
		  return "You are sucessfully updated";
	}else throw new UserExceptions("user not found in DB");
	}
	public Optional<UserInfo> findUser(String username)
	{
		return userRepo.findByUserName(username);
	}
	public UserInfo findU(String username)
	{
		return userRepo.findByGmail(username);
	}
}
