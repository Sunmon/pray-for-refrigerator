/**
 * @class Spring Security관련 설정들을 모아두는 클래스
 * url별 접근 제한 / 로그인 / 권한 설정 등등...
 */
package org.refrigerator.springboot.config.auth;
import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.domain.user.Role;
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
                //TODO: 글쓰기 user role 설정
                //TODO: 레시피 일시적으로 다 풀어놨다.
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile","/recipeBoard", "/recipeSearch").permitAll()
                    .antMatchers("/api/v1/recipe").permitAll()
//                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
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
//                    .and()
//                        .defaultSuccessUrl("/");



    }

}
