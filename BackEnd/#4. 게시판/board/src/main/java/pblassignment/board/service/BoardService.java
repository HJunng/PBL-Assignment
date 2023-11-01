package pblassignment.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pblassignment.board.dto.BoardDTO;
import pblassignment.board.entity.BoardEntity;
import pblassignment.board.repository.BoardRepository;

// DTO -> Entity
// Entity -> DTO

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.saveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

}
