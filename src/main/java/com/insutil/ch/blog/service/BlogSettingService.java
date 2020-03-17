package com.insutil.ch.blog.service;

import com.insutil.ch.blog.model.BlogSetting;
import com.insutil.ch.blog.repository.BlogSettingRepository;
import com.insutil.ch.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogSettingService {
    private static final Logger logger = LoggerFactory.getLogger(BlogSettingService.class);
    private final BlogSettingRepository blogSettingRepository;

    public BlogSetting getBlogSetting(Member member){
        return blogSettingRepository.findBlogSettingByMember(member);
    }
}
