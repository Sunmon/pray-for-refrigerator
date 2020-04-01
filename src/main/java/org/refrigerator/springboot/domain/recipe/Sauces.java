package org.refrigerator.springboot.domain.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Sauces {
    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //PK auto increment
    private Long id;

    //간장,된장,고추장,쌈장...
    @Column(length=20, nullable= false, unique = true)
    private String name;

    @Builder // lombok : 빌더 패턴 클래스 생성
    public Sauces(String name){
        this.name = name;
    }
}
