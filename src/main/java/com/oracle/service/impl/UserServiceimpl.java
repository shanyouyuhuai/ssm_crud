package com.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.mapper.UserMapper;
import com.oracle.service.UserService;
import com.oracle.web.bean.User;
@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserMapper uMapper;
	
	@Override
	@Transactional
	public int save(User user) {
		// TODO Auto-generated method stu
		
		return this.uMapper.saveuser(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return this.uMapper.selectuser(user);
	}

	@Override
	public User vlidateuser(String username) {
		// TODO Auto-generated method stub
		return this.uMapper.validateUser(username);
	}

}
