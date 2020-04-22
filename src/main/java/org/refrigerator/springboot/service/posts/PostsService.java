package org.refrigerator.springboot.service.posts;
import lombok.RequiredArgsConstructor;
import org.refrigerator.springboot.domain.posts.Posts;
import org.refrigerator.springboot.domain.posts.PostsRepository;
import org.refrigerator.springboot.web.dto.posts.PostsListResponseDto;
import org.refrigerator.springboot.web.dto.posts.PostsResponseDto;
import org.refrigerator.springboot.web.dto.posts.PostsSaveRequestDto;
import org.refrigerator.springboot.web.dto.posts.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    /** @RequiredArgsConstructor 가 있기 때문에 생략해도 된다**/
//    public PostsService(PostsRepository postsRepository) {
//        this.postsRepository = postsRepository;
//    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.id=" + id));
        return new PostsResponseDto(entity);
    }

    //readOnly는 조회 속도 개선
    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) //.map(posts->new PostsListResponseDto(posts)와 같음
                .collect(Collectors.toList());
    }

    //게시글 삭제
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsRepository.delete(posts);  //deleteById도 가능
    }
}
