/**
 * 음식 엔티티
 */
package org.refrigerator.springboot.domain.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Food {
    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //PK auto increment
    private Long id;

    //간장국수, 비빔국수, 잔치국수
    @Column(length=50, nullable= false, unique = true)
    private String name;

    //국수, 햄버거
    @Column(length=10)
    private String category;

    @Builder // lombok : 빌더 패턴 클래스 생성
    public Food(String name){
        this.name = name;
    }

    public void update(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
