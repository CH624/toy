package com.insutil.ch.board.model;

import com.insutil.ch.member.model.Member;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "BOARD")
@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String subject;

    @Column
    private String content;

    @CreatedDate
    @Column(name = "write_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date writeDate;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @OneToMany
    @JoinColumn(name = "board_id")
    private List<Reply> replyList;
}
