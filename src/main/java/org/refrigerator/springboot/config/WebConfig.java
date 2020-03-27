/**
 * @class HandlerMethodArgumentResolver가 인식될수 있도록 설정 추가
 */
package org.refrigerator.springboot.config;
import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.config.auth.LoginUserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //HandlerMethodArgumentResolver는 이 메소드를 통해 추가해야 함
        argumentResolvers.add(loginUserArgumentResolver);
    }

}
