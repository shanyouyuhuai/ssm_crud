package com.oracle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.oracle.mapper.SchoolMapper;
import com.oracle.service.SchoolService;
import com.oracle.web.bean.School;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	
	private SchoolMapper SchoolMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<School> list() {
		// TODO Auto-generated method stub
		return SchoolMapper.selectAll();
	}

}
