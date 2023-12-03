package pblassignment.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pblassignment.board.model.DeleteStatus;
import pblassignment.board.model.entity.Board;
import pblassignment.board.model.request.BoardDeleteRequest;
import pblassignment.board.model.request.BoardPostRequest;
import pblassignment.board.model.response.BoardListResponse;
import pblassignment.board.model.response.BoardResponse;
import pblassignment.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // final 붙은거 생성자 만들어줌.
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 등록
    @Transactional
    public BoardResponse writeBoard(BoardPostRequest request) {
        Board board  = new Board();
        board.setTitle(request.getTitle());
        board.setBody(request.getBody());
        board.setDeleteStatus(DeleteStatus.ACTIVE); // 새로 생성되는 글은 처음에 ACTIVE

        // JPA 의 가장 강력한 기능!! Repository가 비어있음에도
        // 저장할 수 있음.
        return BoardResponse.from(boardRepository.save(board));

    }

    /**
     * 게시글 목록 조회
     * @param page
     * @param pageSize 보통 프론트한테 유연하게 사용할 수 있도록 넘겨받음.
     * @return
     */
    public List<BoardListResponse> searchBoardList(int page, int pageSize){
        return boardRepository.findAllByDeleteStatus(
                DeleteStatus.ACTIVE,
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "boardNo"))
        ).map(BoardListResponse::from).toList();
    }

    // 게시글 단건 조회 (게시글 + 댓글)
    public BoardResponse searchBoard(Long boardNo){
        return boardRepository.findBoardWithCommentsByBoardNo(boardNo)
                .map(BoardResponse::from)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));
    }

    // 게시글 삭제
    @Transactional
    public String deleteBoard(BoardDeleteRequest request){
        Optional<Board> boardOptional = boardRepository.findById(request.getBoardNo());
        Board board = boardOptional.orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));

        boardRepository.delete(board);

        return "OK";
    }
}
