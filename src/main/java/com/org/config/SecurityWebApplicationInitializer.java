package com.org.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


// 상속만으로 springSecurityFilterChain이 서블릿 필터로 등록된다.
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}
