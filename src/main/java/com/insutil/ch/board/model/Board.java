package com.insutil.ch.board.model;

import com.insutil.ch.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "BOARD")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @Column
    private String content;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @OneToMany
    @JoinColumn(name = "board_id")
    private List<Reply> replyList;
}
