/**
 * @class 인증된 사용자 정보를 저장하는 DTO
 */
package org.refrigerator.springboot.config.auth.dto;

import lombok.Getter;
import org.refrigerator.springboot.domain.user.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
