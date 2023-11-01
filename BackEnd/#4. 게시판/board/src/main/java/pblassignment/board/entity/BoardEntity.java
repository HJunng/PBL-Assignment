package pblassignment.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pblassignment.board.dto.BoardDTO;

// DB 테이블 역할을 히는 클래스
@Entity
@Getter @Setter
@Table(name = "Post")
public class BoardEntity extends BaseEntity{ // BaseEntity를 상속받아서 TimeStamp도 사용 가능함.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String boardWriter;

    @Column // default: 크기 255, null 가능
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity saveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }
}
