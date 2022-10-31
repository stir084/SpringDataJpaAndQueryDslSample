package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface dslAndDatajpaRepositoryCustom{
    List<Member> findByName(String name);
}
