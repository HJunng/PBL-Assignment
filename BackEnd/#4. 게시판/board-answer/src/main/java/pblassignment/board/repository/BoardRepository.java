package pblassignment.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pblassignment.board.model.DeleteStatus;
import pblassignment.board.model.entity.Board;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    // 특정 조건으로 조회를 할때 만들어줘야 함
    Page<Board> findAllByDeleteStatus(DeleteStatus deleteStatus, Pageable pageable);

    // JPQL 사용
    @Query("SELECT b FROM Board b LEFT JOIN FETCH b.comments c WHERE b.boardNo = :boardNo")
    Optional<Board> findBoardWithCommentsByBoardNo(@Param("boardNo") Long boardNo);
}
