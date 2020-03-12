package com.insutil.ch.member.model;

import com.insutil.ch.group.model.Group;
import com.insutil.ch.security.model.Authority;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Setter
@Getter
@NoArgsConstructor
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

    @ManyToOne
    private Group group;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private List<Authority> roles;
}
