package com.insutil.ch.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
public class Member {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "login_id", unique=true)
    private String loginId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;
}
