package com.oracle.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.oracle.mapper.MonsterMapper;
import com.oracle.web.bean.SubMonster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestMapper {

	@Autowired
	private MonsterMapper mosMapper;
	
	@Test
	public void testpage(){
		
		PageHelper.startPage(1,2);
		
	List<SubMonster> list=this.mosMapper.selectAllByPage();
	
	for (SubMonster s: list) {
		
		System.out.println(s);
	}
	}
	
}
