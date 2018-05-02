package com.notepubs.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

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

	@GetMapping("book-list-partial")
	public String bookListPartial() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "book-list-partial";
	}
	
	@GetMapping("note-photo-list")
	@ResponseBody
	public String notePhotoList(HttpServletRequest request) {
				
		String url = "/resource/js/images";
		String path = request.getServletContext().getRealPath(url);
		
		List<String> fileNames = new ArrayList<>();
		File file = new File(path);
		
		File[] files = file.listFiles();
		for(File f : files){
			fileNames.add(f.getName());
		}
		
		Gson gson = new Gson();
		
		String json = gson.toJson(fileNames);
		
		return json;
		
		/*StringBuilder builder = new StringBuilder();
		
		builder.append("[");
		for(int i=0; i<fileNames.size(); i++) {
			builder.append(fileNames.get(i));
			if(i<fileNames.size()-1)
				builder.append(",");
		}
		builder.append("]");
		
		return builder.toString();*/
		
	}
}

