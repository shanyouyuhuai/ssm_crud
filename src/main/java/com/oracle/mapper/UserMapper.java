package com.oracle.mapper;

import com.oracle.web.bean.User;

public interface UserMapper {

	int saveuser(User user); 
	
	User selectuser(User user);
	
	User validateUser(String username);
}
