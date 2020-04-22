/**
 * @class Post response Dto
 * @why Entity필드 중 일부만 사용하므로 Entity를 따로 처리하는 Dto 클래스 만들음
 */
package org.refrigerator.springboot.web.dto.posts;

import lombok.Getter;
import org.refrigerator.springboot.domain.posts.Posts;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
