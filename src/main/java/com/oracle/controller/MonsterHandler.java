package com.oracle.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.oracle.service.MonsterService;
import com.oracle.service.SchoolService;
import com.oracle.web.bean.Monster;
import com.oracle.web.bean.School;
import com.oracle.web.bean.SubMonster;
import com.oracle.web.bean.pageBean;

@Controller
@Scope(value="prototype")
public class MonsterHandler {

	@Autowired
	private MonsterService monsterService;
	
	@Autowired
	private SchoolService schoolService;
	
/*	@RequestMapping(value = "/monsters", method = RequestMethod.GET)
	public String monsters(HttpServletRequest request) {

		List<SubMonster> list = monsterService.list();

		request.setAttribute("mlist", list);

		return "list";
	}
*/
	@RequestMapping(value = "/monsters", method = RequestMethod.GET)
	public String FenList(Integer pageNow,HttpServletRequest request){
	
		if(pageNow==null){
			pageNow=1;
		}
		pageBean<SubMonster> pb=this.monsterService.selectAllByPage(pageNow);
		
		request.setAttribute("pb", pb);
		
		System.out.println(pb);
		return "list";
	
	

}
	
	@RequestMapping(value = "/addUI", method = RequestMethod.GET)
	public String addUI(HttpServletRequest request) {

		List<School> school = schoolService.list();

		request.setAttribute("slist", school);

		return "add";

	}

	@RequestMapping(value = "/monster", method = RequestMethod.POST)

	public String monster(Monster monster) {

		monsterService.save(monster);

		return "redirect:/monsters";
	}

	@RequestMapping(value = "/monster/{monsterId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("monsterId") Integer id) {

		Monster m = new Monster();

		m.setMonsterId(id);

		monsterService.delete(m);

		return "redirect:/monsters";
	}

	@RequestMapping(value = "/monster/{monsterId}", method = RequestMethod.GET)

	public String updateUI(@PathVariable("monsterId") Integer id, HttpSession session) {

		Monster monster = monsterService.queryOneMonster(id);

		session.setAttribute("monster", monster);

		List<School> schoolList = schoolService.list();

		session.setAttribute("slist", schoolList);

		return "redirect:/update.jsp";

	}

	@RequestMapping(value = "/monster", method = RequestMethod.PUT)

	public String update(Monster monster) {

		monsterService.update(monster);

		return "redirect:/monsters";
	}

}
