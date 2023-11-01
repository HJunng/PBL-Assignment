package pblassignment.board.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

// DTO : Data Transfer Object

@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
@NoArgsConstructor // 기본 생성자
@Getter @Setter
@ToString // 필드값 확인용
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;
}
