package pblassignment.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pblassignment.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
