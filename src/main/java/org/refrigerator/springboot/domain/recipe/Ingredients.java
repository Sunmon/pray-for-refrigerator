/** 재료 엔티티
 *
 */
package org.refrigerator.springboot.domain.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Ingredients {
    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //PK auto increment
    private Long id;

    //고구마, 참치캔, 당면, 떡
    @Column(length=20, nullable= false, unique = true)
    private String name;

    //고기, 생선, 풀, 면...
    @Column(length=10)
    private String category;

    
    @Builder // lombok : 빌더 패턴 클래스 생성
    public Ingredients(String name){
        this.name = name;
    }


}
