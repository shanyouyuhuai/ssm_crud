package com.oracle.mapper;

import com.oracle.web.bean.Monster;
import com.oracle.web.bean.SubMonster;
import com.oracle.web.bean.pageBean;

import java.util.List;

public interface MonsterMapper {
 
    int deleteByPrimaryKey(Integer monsterId);

    int insert(Monster record);

    Monster selectByPrimaryKey(Integer monsterId);

    List<SubMonster> selectAll();
 
    List<SubMonster> selectAllWithOneSQL();
    
    int updateByPrimaryKey(Monster record);
    
    List<SubMonster> showpage(Integer index);

	int selectCount();

	List<SubMonster> selectAllByPage();

	
}