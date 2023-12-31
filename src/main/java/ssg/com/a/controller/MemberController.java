package ssg.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login.do")
	public String login() {
		System.out.println("MemberController login()" + new Date());
		return "login";
	}
	
	@GetMapping("regi.do")
	public String regi() {
		System.out.println("MemberController regi()" + new Date());
		return "regi";
	}
	
	@ResponseBody  //ajax 쓸 때 필수로 써주기 !!  
	@PostMapping("idcheck.do")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck()" + new Date());
		boolean isS = service.idcheck(id);
		String msg = "YES";
		if(isS == true) {
			msg = "NO";
		}
		return msg;
	}
	
	@PostMapping("regiAf.do")
	public String regiAf(MemberDto dto, Model model) {
		System.out.println("MemberController regiAf()" + new Date());
		boolean isS = service.addmember(dto);
		
		String message = "MEMBER_YES";
		if(isS == false) {
			message = "MEMBER_NO";
		}		
		
		model.addAttribute("message", message);
		return "message";
	}
	
//	@PostMapping("login.do")
//	public String login(MemberDto dto) { // HttpServletRequest request 이런 것도 사용 가능 
//		System.out.println("MemberController loginAf()" + new Date());
//		boolean loginS = service.login(dto);
//		
//		String location = "home";
//		if(!loginS){
//			location = "login";
//		}
//		
//		return location;
//	}
	
	// Model model 처럼
	// request가 필요할 때 HttpServletRequest request
	// session이 필요할 때 HttpSession session
	// request.getSession().setAttribute("login", dto); // session에 저장 
	// 이런 식으로 사용 가능 
	
	@PostMapping("loginAf.do")
	public String login(MemberDto mem, Model model, HttpServletRequest request) {
		System.out.println("MemberController login() " + new Date());
		
		MemberDto dto = service.login(mem);
		String loginmsg = "LOGIN_NO";
		if(dto != null) {
			request.getSession().setAttribute("login", dto);	// session에 저장			
			loginmsg = "LOGIN_YES";
		}
		model.addAttribute("loginmsg", loginmsg);
		
		return "message";
	}
	
}
