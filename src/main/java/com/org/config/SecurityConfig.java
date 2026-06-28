package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // TODO: PasswordEncoder Bean 등록
    // 비밀번호를 암호화할 빈 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // TODO: InMemoryUserDetailsManager Bean 등록
    // 테스트용 메모리 사용자 등록
    // 데이터베이스를 연결하지 않았으므로, 서버 메모리에 가상 사용자를 저장해두는 방식이다.
    // 파라미터로 위에서 만든 paswordencoder를 주입받아 비밀번호를 암호화하여 저장한다.
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        // UserDetails는 스프링 시큐리티가 인식하는 '표준 사용자 정보 인터페이스'다
        UserDetails user = User.withUsername("duke")
                .password(encoder.encode("1111"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("1111"))
                .roles("ADMIN")
                .build();

        // 메모리에 이 가상 유저 duke를 등록하여 관리하는 매니저 객체를 반환한다.
        return new InMemoryUserDetailsManager(user, admin);
    }

    // TODO: SecurityFilterChain Bean 등록
    // 보안 필터 체인 설정
    // 어떤 주소로 들어올 때 검사를 할지, 안 할지 문지기의 행동 지침을 구성하는 가장 중요한 메서드
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                // 인가 설정 - URL별 접근 권한을 정의
                .authorizeRequests(auth -> auth
                        .antMatchers("/resources/**").permitAll()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/members/**").hasRole("USER")
                        .anyRequest().authenticated())
                // 인증 - 로그인
                .formLogin(Customizer.withDefaults())
                // 로그아웃
                .logout(Customizer.withDefaults());

        return http.build();
    }
}
