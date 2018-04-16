package com.notepubs.web.controller.author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("authorHomeController")
@RequestMapping("/author/")
public class HomeController {
	
	/*private HomeService service;*/
	
	@GetMapping("index")
	public String index() {
		return "author.index";
	}
}
