package pblassignment.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pblassignment.board.model.request.CommentDeleteRequest;
import pblassignment.board.model.request.CommentPostRequest;
import pblassignment.board.model.response.BoardResponse;
import pblassignment.board.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("/comment")
    public BoardResponse writeComment(
            @RequestBody CommentPostRequest commentPostRequest
            ){
        return commentService.writeComment(commentPostRequest);
    }

    // 댓글 삭제
    @DeleteMapping("comment")
    public String deleteComment(
            @RequestBody CommentDeleteRequest commentDeleteRequest
            ){
        return commentService.deleteComment(commentDeleteRequest);
    }
}
