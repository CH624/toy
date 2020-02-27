package com.insutil.ch.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column()
    private String id;

    @Column()
    private String name;

    @Column()
    private int age;
}
