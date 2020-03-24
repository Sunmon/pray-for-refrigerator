package org.refrigerator.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter     //모든 필드의 get메소드 자동생성
@RequiredArgsConstructor    //모든 final필드가 포함된 생성자 자동생성. final없으면 생성자에 포함 x
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
