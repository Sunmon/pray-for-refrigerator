/**
 * @role JpaRepository
 * @description 보통 Dao라고 불리는 DB Layer 접근자.
 *  JPA에서는 Repository라고 부르고 인터페이스로 생성
 * @note Entity클래스와 Entity repository는 함께 위치해야 함
 */
package org.refrigerator.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository 상속
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
