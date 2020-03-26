package org.refrigerator.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //Spring Security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                //h2-console화면 사용하기 위해 option disable
                .csrf().disable()
                .headers().frameOptions().disable()

                //권한 관리 대상 지정
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest() .authenticated()
                //로그아웃 설정
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                //로그인 성공 이후 설정
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);  //user service인터페이스 구현체 등록
    }

}
