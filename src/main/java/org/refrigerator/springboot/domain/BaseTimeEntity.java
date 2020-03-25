/**
 * @class 모든 Entity의 상위 클래스
 * @role  createDate, modifiedDate를 자동으로 관리
 */
package org.refrigerator.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //JPA Entity가 이 클래스를 상속할경우 필드(creteData, modifiedData)도 Column으로 인식하도록 설정
@EntityListeners(AuditingEntityListener.class)  //Auditing기능 추가
public abstract class BaseTimeEntity {

    @CreatedDate    //Entity 생성될때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate   //Entity 값 변경시간 자동 저장
    private LocalDateTime modifiedDate;

}
