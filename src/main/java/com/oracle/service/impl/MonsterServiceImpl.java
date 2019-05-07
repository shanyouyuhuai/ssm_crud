package com.oracle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.MonsterMapper;
import com.oracle.service.MonsterService;
import com.oracle.web.bean.Monster;
import com.oracle.web.bean.SubMonster;
import com.oracle.web.bean.pageBean;

@Service
public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterMapper MonsterMapper;

	@Override
	@Transactional(readOnly=true)
	public List<SubMonster> list() {
		// TODO Auto-generated method stub
		return this.MonsterMapper.selectAll();
	}

	@Override
	@Transactional
	public int save(Monster monster) {
		// TODO Auto-generated method stub
		return this.MonsterMapper.insert(monster);
	}

	@Override
	@Transactional
	public void delete(Monster monster) {
		// TODO Auto-generated method stub
		
		this.MonsterMapper.deleteByPrimaryKey(monster.getMonsterId());
	}

	@Override
	@Transactional(readOnly=true)
	public Monster queryOneMonster(Integer monsterId) {
		// TODO Auto-generated method stub
		return this.MonsterMapper.selectByPrimaryKey(monsterId);
	}

	@Override
	@Transactional
	public void update(Monster monster) {
		// TODO Auto-generated method stub
		
		this.MonsterMapper.updateByPrimaryKey(monster);
	}

	@Override
	@Transactional(readOnly=true)
	public pageBean<SubMonster> showpage(Integer pageNow, int pageSize) {

		pageBean<SubMonster> pb = new pageBean<SubMonster>();

		pb.setPageNow(pageNow);

		pb.setPageSize(pageSize);
		
		//查看有多少条
		int sum=MonsterMapper.selectCount();
		
		pb.setCounts(sum);
		
		//从第几条开始
		int index=(pageNow-1)*pageSize;
		
		List<SubMonster> list=this.MonsterMapper.showpage(index);
		
		pb.setBeanList(list);
		
		return pb;
	}

	@Override
	public pageBean<SubMonster> selectAllByPage(Integer pageNow) {
		// TODO Auto-generated method stub
		
		pageBean<SubMonster> pb=new pageBean<SubMonster>();
		
		PageHelper.startPage(pageNow,2);
		
	List<SubMonster>list=this.MonsterMapper.selectAllByPage();
	
	   pb.setBeanList(list);
	   
	   //总记录数
	   PageInfo<SubMonster> pi=new PageInfo<SubMonster>(list);
	   
	   pb.setCounts((int) pi.getTotal());
		//当前页
		pb.setPageNow(pi.getPageNum());
		
		// 每页显示的数据
		pb.setPageSize(2);
		
		return pb;
	}
	}

