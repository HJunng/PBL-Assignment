package pblassignment.board.model.request;

import lombok.Data;

@Data
public class CommentPostRequest {
    private Long boardNo; // 어떤 게시판에
    private String commentBody; // 어떤 댓글을 달거야
}
