package org.refrigerator.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //어노테이션을 PARAMETER로 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {   //어노테이션 클래스
}
