package com.org.config;
/*
Spring MVC 설정
@EnableWebMvc
@ComponentScan
JSP ViewResolver 등록
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // Spring 설정 클래스라는 뜻이며 XML 설정 파일 대신 Java 코드로 Bean 설정을 작성하는 곳이다.
@EnableWebMvc  // Spring MVC 기능을 키는 것, @GetMapping, @PostMapping, HandlerMapping, HandlerAdapter 같은 MVC 기본 구성을 활성화한다.
@ComponentScan(basePackages = "com.org.springmvc") // 해당 패키지 아래에서 @Controller @Service @Repository @Component가 붙은 클래스를 찾아 Spring Bean으로 등록한다.
public class WebMvcConfig {
    @Bean // viewResolver 등록
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
