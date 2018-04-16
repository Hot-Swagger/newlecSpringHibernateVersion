package com.notepubs.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*보안과 관련된 필더를 통해 가장 우선적으로 인터셉트 할수 있도록 설정
<filter>
  <filter-name>springSecurityFilterChain</filter-name>
  <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
  <filter-name>springSecurityFilterChain</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>*/

//springSecurityFilterChain (보안필터 적용) configure 파일 지정 안하고 그냥 만들어 놓기만 하면 된다
public class NotepubsSecurityWebAppliactionInitializer
	extends AbstractSecurityWebApplicationInitializer{

}
