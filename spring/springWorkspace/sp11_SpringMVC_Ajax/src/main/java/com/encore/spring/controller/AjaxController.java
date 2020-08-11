package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {
	/*
	 * ModelAndView
	 * View Page Name + ModelData
	 * 
	 * ModelAndView 객체 안 쓰고 아래 코드처럼 쓸 수도 있다. 더 업된 버전.
	 */
	@RequestMapping("insert.do")
	public String insert(Model model) {
		System.out.println("동기 통신.......");
		model.addAttribute("info", "와~~~ 동기통신이닷!!!!");
		return "insert_result"; //결과페이지 이름
	}
	
	@RequestMapping("SearchId.do")
	public ModelAndView search() {
		System.out.println("비동기 통신....");
		
		//리다이렉트 쓸 때
		//return new ModelAndView("redirect:/index.jsp");
		//return new ModelAndView("redirect:/allMember.do");
		
		return new ModelAndView("JsonView", "person", new Person("아이유", "서초동")); //요청페이지 이름 쓰면 됨. 컨벤션..
	}
}