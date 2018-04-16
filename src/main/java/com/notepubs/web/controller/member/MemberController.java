package com.notepubs.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notepubs.web.entity.Member;
import com.notepubs.web.service.member.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("login")
	public String login() {
		
		return "member.login";
	}
		
	@GetMapping("join")
	public String join() {
		
		return "member.join";
	}
	
	@PostMapping("join")
	public String join(Member member) {
		
		
		String pwd = member.getPwd();
		/*암호화도구*/
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPwd = passwordEncoder.encode(pwd); 
		
		member.setPwd(hashedPwd);
		
		service.insertMember(member);
		
		return "redirect:join";
		
	}
}
