package com.oracle.service;

import com.oracle.web.bean.User;

public interface UserService {

	int save(User user);

	User login(User user);

	User vlidateuser(String username);

}
