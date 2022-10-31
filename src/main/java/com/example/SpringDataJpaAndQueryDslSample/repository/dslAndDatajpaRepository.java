package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface dslAndDatajpaRepository extends JpaRepository<Member, Long>, dslAndDatajpaRepositoryCustom{

}
