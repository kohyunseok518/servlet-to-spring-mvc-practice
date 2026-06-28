package com.org.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
web.xml 대체
Tomcat이 시작될 때 DispatcherServlet을 Java 코드로 등록
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // RootConfig 등록
    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    // WebMvcConfig 등록
    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMvcConfig.class};
    }

    // DispatcherServlet 매핑 경로 설정
    @Override
    public String[] getServletMappings() {
        return new String[] {"/"};
    }
}
