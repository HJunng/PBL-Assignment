package pblassignment.board.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import pblassignment.board.model.DeleteStatus;
import pblassignment.board.model.entity.Comment;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long commentNo;
    private String body;

    // new 연산을 피하고자 -> 정적 팩토리 메서드
    // from으로 넘길테니까 너가 dto 만들어줘.
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getCommentNo(), comment.getBody());
    }
}
