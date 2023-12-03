package pblassignment.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pblassignment.board.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
