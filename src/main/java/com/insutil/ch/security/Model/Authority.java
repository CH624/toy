package com.insutil.ch.security.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="AUTHORITY")
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="login_id")
    private String loginId;

    @Column
    private String authority;
}
