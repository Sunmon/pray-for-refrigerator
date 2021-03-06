/** 관계테이블
 *  Food-Ingredients 연결
 *  Many-to-Many쓰는 대신 이 관계테이블 이용
 */
package org.refrigerator.springboot.domain.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe {
    @Id //PK(Primary Key)
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //PK auto increment
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "NAME")
    private Food food;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "NAME")
    private Ingredient ingredient;

    @Column(nullable = false)
    private boolean mainMaterial = false;


    @Builder // lombok : 빌더 패턴 클래스 생성
    public Recipe(Food food, Ingredient ingredient, boolean mainMaterial){
        this.food = food;
        this.ingredient = ingredient;
        this.mainMaterial = mainMaterial;
    }
}
