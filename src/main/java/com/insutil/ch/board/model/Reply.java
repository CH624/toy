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

    @OneToOne
    private Board board;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member writer;
}
