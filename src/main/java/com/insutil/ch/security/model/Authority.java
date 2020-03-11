package com.insutil.ch.security.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="AUTHORITY")
@Getter
@Setter
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String authority;

    public Authority(String authority){
        this.authority = authority;
    }
}
