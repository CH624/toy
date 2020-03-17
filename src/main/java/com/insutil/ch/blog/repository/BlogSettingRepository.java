package com.insutil.ch.blog.repository;

import com.insutil.ch.blog.model.BlogSetting;
import com.insutil.ch.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogSettingRepository extends JpaRepository<BlogSetting, Long> {
    BlogSetting findBlogSettingByMember(Member member);
}
