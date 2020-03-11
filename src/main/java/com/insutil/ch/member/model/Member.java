package com.insutil.ch.member.model;

import com.insutil.ch.board.model.Board;
import com.insutil.ch.security.model.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login_id", unique=true)
    private String loginId;

    @Column
    private String password;

    @Column
    private String name;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Authority> roles;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="member_id")
    private List<Board> boardList;
}
