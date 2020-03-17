package com.insutil.ch.blog.model;

import com.insutil.ch.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BLOG_SETTING")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogSetting {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String title;

    @OneToOne
    private Member member;
}
