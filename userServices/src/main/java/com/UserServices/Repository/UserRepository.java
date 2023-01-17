package com.UserServices.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserServices.models.UserInfo;
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	public UserInfo findByGmail(String gmail);
	public Optional<UserInfo> findByUserName(String userName);

}
