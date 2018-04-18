package com.notepubs.web.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.notepubs.web.service.member.MemberService;

@Component
public class NotepubsLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private MemberService service;
	
	private RedirectStrategy redirectStrategy;
	
	@Override
	public void onAuthenticationSuccess
	(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		//login 시 아이디 가져오기
		String memberId = authentication.getName();
		//login 성공한 아이디에서 ROLE 가져오기
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(memberId);
		for(String role : roles)
			System.out.println(role);
		
		//session에서 저장된 정보가져오기
		HttpSession session = request.getSession();
		
		if(session != null) {
			// savedRequest 는 스프링security 라이브러리에서 보안설정된 페이지이동을 인터셉트 했을경우 요청정보를 저장하는 객체
			SavedRequest savedRequest = (SavedRequest)session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			
			//redirect 생성도구 객체 생성
			redirectStrategy = new DefaultRedirectStrategy();
			
			// 보안설정된 페이지 이동을 인터셉트하여 간접요청됬을경우
			if(savedRequest != null) {				
				
				//savedRequest에서 redirectUrl을 가져오는 작업
				String returnUrl = savedRequest.getRedirectUrl();
				System.out.println(returnUrl);
				
				//redirect 생성도구를 통해 요청페이지로 리다이렉트(포워딩)
				redirectStrategy.sendRedirect(request, response, returnUrl);
			}
			
			// 직접 로그인페이지가 요청됐을 경우 (savedRequest에 이전 url 저장이 안됐을 경우)
			else {
				//직접 로그인시 역할별로 기본 페이지 리다이렉트를 설정하기
				String defaultRole = service.getDefaultRoleByMemberId(memberId);
				
				switch(defaultRole) {
				case "ROLE_AUTHOR":
					redirectStrategy.sendRedirect(request, response, "/author/index");
					break;
				case "ROLE_ADMIN":
					redirectStrategy.sendRedirect(request, response, "/admin/index");
					break;
				default:
					// error 페이지로 보낸다
					break;
				}
			}
			
		}
		
	}

}
