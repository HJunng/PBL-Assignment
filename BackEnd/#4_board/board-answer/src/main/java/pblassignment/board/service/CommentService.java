package pblassignment.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pblassignment.board.model.entity.Board;
import pblassignment.board.model.entity.Comment;
import pblassignment.board.model.request.CommentDeleteRequest;
import pblassignment.board.model.request.CommentPostRequest;
import pblassignment.board.model.response.BoardResponse;
import pblassignment.board.repository.BoardRepository;
import pblassignment.board.repository.CommentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    // 댓글 등록
    // 댓글이 잘 작성되었는지 확인하기 위해서 return 타입 명시
    @Transactional
    public BoardResponse writeComment(CommentPostRequest request) {
        Optional<Board> boardOptional = boardRepository.findBoardWithCommentsByBoardNo(request.getBoardNo());
        Board board = boardOptional.orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));

        board.addComment(request.getCommentBody());
        boardRepository.save(board);

        return BoardResponse.from(board); // 우리가 만든거 보여주자.
    }

    // 댓글 삭제
    @Transactional
    public String deleteComment(CommentDeleteRequest request){
        Optional<Comment> commentOptional = commentRepository.findById(request.getCommentNo());
        Comment comment = commentOptional.orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다."));

        if(comment.getBoard().getBoardNo().equals(request.getBoardNo())){
            commentRepository.delete(comment);
        }else{
            throw new RuntimeException("이 댓글은 게시글에 없는 댓글입니다.");
        }

        return "OK";
    }

}
