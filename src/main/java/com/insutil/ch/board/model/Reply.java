package com.insutil.ch.board.model;

import com.insutil.ch.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Table(name = "REPLY")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    private Board board;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    public void setBoard(Board board){
        if(this.board != null ) {
            this.board.getReplyList().remove(this);
        }
        this.board = board;
        board.getReplyList().add(this);
    }
}
