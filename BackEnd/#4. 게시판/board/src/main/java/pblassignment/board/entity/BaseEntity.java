package pblassignment.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreationTimestamp // 생성되었을 때 시간을 만들어줌.
    @Column(updatable = false) // update할 때는 관여 x
    private LocalDateTime createdTime;

    @CreationTimestamp // 업데이트를 했을 때 시간을 준다.
    @Column(insertable = false) // insert 할때는 관여 x
    private LocalDateTime updatedTime;
}
