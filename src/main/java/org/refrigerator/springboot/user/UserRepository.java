package org.refrigerator.springboot.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);   //email로 이미 아이디가 있는지 확인
}
