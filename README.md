# Servlet to Spring MVC Practice

순수 Java Servlet부터 시작해 Servlet + JSP, MVC 패턴, 직접 만든 Front Controller를 거쳐 Spring MVC까지 단계적으로 발전시키는 실습 프로젝트입니다.

완성 코드를 한 번에 만드는 것이 아니라, 각 단계에서 불편함을 직접 경험하고 그 문제를 다음 구조로 해결하는 것을 목표로 합니다.

## 기술 조건

- Java 21
- Gradle
- WAR 프로젝트
- 외부 Tomcat 9.x
- Jakarta EE 8 기반
- `javax.servlet` 사용
- Spring Boot 사용 안 함
- Spring Legacy 기반
- Java Config 사용
- JSP 사용
- DB 없이 메모리 저장소 사용

## 기능

- 회원 등록
- 회원 목록 조회

## 진행 단계

### 1단계: 순수 Servlet

- `HttpServlet` 상속
- `HttpServletRequest`, `HttpServletResponse` 직접 사용
- `web.xml`에 Servlet 직접 등록
- HTML을 Java 코드에서 `response.getWriter()`로 직접 작성
- 메모리 저장소에 회원 저장

현재 확인한 문제:

- Java 코드 안에 HTML 문자열이 많아진다.
- 요청 URL마다 Servlet 클래스를 만들고 `web.xml`에 등록해야 한다.
- 같은 URL(`/members`)에 여러 Servlet을 매핑할 수 없다.
- 화면 출력, 요청 처리, 비즈니스 로직이 Servlet 안에 섞인다.

### 2단계: Servlet + JSP

- Servlet은 요청 처리 담당
- JSP는 화면 출력 담당
- `request.setAttribute()` 사용
- `RequestDispatcher.forward()` 사용

### 3단계: MVC 패턴

- Controller, Model, View 역할 분리
- Controller가 View 이름과 Model 데이터를 반환하도록 개선

### 4단계: 직접 만든 Front Controller

- 모든 요청을 하나의 FrontControllerServlet이 받도록 변경
- URL과 Controller를 Map으로 연결
- ModelView, ViewResolver, View 객체 직접 구현

### 5단계: Spring MVC

- Spring Framework 기반
- Spring Boot 사용 안 함
- DispatcherServlet 직접 등록
- Java Config 사용
- `@Controller`, `@GetMapping`, `@PostMapping` 사용
- JSP ViewResolver 직접 설정

## Servlet / Tomcat 선택

이 프로젝트는 Tomcat 9.x를 사용하므로 Servlet API는 `javax.servlet` 계열을 사용합니다.

```gradle
compileOnly 'javax.servlet:javax.servlet-api:4.0.1'
