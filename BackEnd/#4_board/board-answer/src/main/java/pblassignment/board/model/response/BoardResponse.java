package pblassignment.board.model.response;

// 어떤 게시물이 만들어졌는지

import lombok.AllArgsConstructor;
import lombok.Data;
import pblassignment.board.model.DeleteStatus;
import pblassignment.board.model.entity.Board;
import pblassignment.board.model.entity.Comment;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class BoardResponse {
    private Long boardNo;
    private String title;
    private String body;
    private DeleteStatus deleteStatus;
    private List<CommentResponse> comments;

    // 정적 팩토리 메서드
    public static BoardResponse from(Board board){
        return new BoardResponse(
                board.getBoardNo(),
                board.getTitle(),
                board.getBody(),
                board.getDeleteStatus(),
                board.getComments().stream().map(CommentResponse::from).collect(Collectors.toList())
        );
    }

}
