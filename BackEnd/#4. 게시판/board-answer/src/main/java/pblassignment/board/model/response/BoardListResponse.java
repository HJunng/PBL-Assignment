package pblassignment.board.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import pblassignment.board.model.entity.Board;

@Data
@AllArgsConstructor
public class BoardListResponse {
    private Long boardNo;
    private String title;

    // 정적 팩토리 메서드
    public static BoardListResponse from(Board board){
        return new BoardListResponse(
                board.getBoardNo(),
                board.getTitle()
        );
    }
}
