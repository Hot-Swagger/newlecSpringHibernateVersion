package com.notepubs.web.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notepubs.web.service.HomeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	/*@Autowired
	private HomeService service;*/
	
	@GetMapping("index")
	public String index(@CookieValue(value="vid", defaultValue="") String vid
						, HttpServletResponse response
						, Model model) {
		// 1.parameter, 2.@PathVariable, 3.@CookieValue
		
		// 랜덤 id 추출
		if(vid == null || vid.equals("")) {
			vid = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("vid", vid);
			cookie.setMaxAge(60*60*24*365);	//	유효기간 1년
			cookie.setPath("/");	// 쿠키를 가져올수 있는 위치 설정
			
			response.addCookie(cookie);
		}
		else
			model.addAttribute("visited", "true");
		
		return "index";
	}
}
