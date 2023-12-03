package pblassignment.board.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import pblassignment.board.model.DeleteStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE board SET DELETE_STATUS = 'DELETE' WHERE board_no = ?")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db한테 ddl 권한을 넘김.
    private Long boardNo;

    private String title;
    @Column(length = 1000)
    private String body;
    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL) // 보드가 지워지면 댓글도 사라짐.
    @Where(clause = "DELETE_STATUS = 'ACTIVE'")
    private List<Comment> comments = new ArrayList<>();

    // 연관관계 헬퍼 메서드
    public Board addComment(String commentBody){
        Comment comment = new Comment();
        comment.setBody(commentBody);
        comment.setBoard(this);
        comment.setDeleteStatus(DeleteStatus.ACTIVE);

        this.getComments().add(comment);
        return this;
    }

}
