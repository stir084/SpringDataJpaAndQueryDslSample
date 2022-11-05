package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DslAndDatajpaRepository extends JpaRepository<Member, Long>, DslAndDatajpaRepositoryCustom {

}
