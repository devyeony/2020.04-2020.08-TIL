package com.encore.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member vo = memberService.login(id, password);
		request.getSession().setAttribute("vo", vo);
		return "login_result";
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("viewAllMember.do")
	public String viewAllMember(Model model) {
		List<Member> list = memberService.viewAllMember();
		model.addAttribute("list", list);
		return "allView";
	}
	
	@RequestMapping("idCheck.do")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		boolean flag = memberService.idCheck(id);
		PrintWriter out = response.getWriter();
		out.print(flag);
	}

	@RequestMapping("idCheck2.do")
	public String idCheck2(HttpServletRequest request, Model model) throws IOException {
		String id = request.getParameter("id");
		boolean flag = memberService.idCheck(id);
		model.addAttribute("flag", flag);
		return "idcheck";
	}
	
	@RequestMapping("findMember.do")
	public String findMember(String id, Model model) {
		Member vo = memberService.findMember(id);
		if(vo==null) {
			return "find_fail";
		}else {
			model.addAttribute("vo", vo);
			return "find_ok";
		}
	}
	
	@RequestMapping("registerMember.do")
	public ModelAndView registerMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		Member vo = new Member(id, pwd, name, addr);
		System.out.println(id+", "+pwd+", "+name+", "+addr);
		memberService.registerMember(vo);
		return new ModelAndView("redirect:/index.jsp");
	}
	
	@RequestMapping("updateMember.do")
	public String updateMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		Member vo = new Member(id, pwd, name, addr);
		memberService.updateMember(vo);
		request.getSession().setAttribute("vo", vo);
		return "update_result";
	}
}
