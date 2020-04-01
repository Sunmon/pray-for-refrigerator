/** 관계테이블
 *  Food-Ingredients 연결
 *  Many-to-Many쓰는 대신 이 관계테이블 이용
 */
package org.refrigerator.springboot.domain.recipe;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Recipe {
    @Id //PK(Primary Key)
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //PK auto increment
    private Long id;

    //TODO: JoinColum(name)넣으면 빨간줄 쳐져서 삭제함
    @ManyToOne
    @JoinColumn()
    private Food food;

    @ManyToOne
    @JoinColumn()
    private Ingredient ingredient;



//    @JoinColumn(name = "ingredients_id")
//    private Ingredients ingredients;
}
