package com.insutil.ch.security.repository;

import com.insutil.ch.security.Model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<List<Authority>> findByLoginId(String loginId);
}
