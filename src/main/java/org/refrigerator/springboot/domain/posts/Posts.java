package org.refrigerator.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok : Getter 자동 생성
@NoArgsConstructor  //lombok : public Posts(){} 기본 생성자 자동 생성
@Entity //JPA
public class Posts {
    @Id //PK(Primary Key)
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //PK auto increment
    private Long id;

    @Column(length=500, nullable= false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable =false)
    private String content;

    private String author;

    @Builder // lombok : 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
