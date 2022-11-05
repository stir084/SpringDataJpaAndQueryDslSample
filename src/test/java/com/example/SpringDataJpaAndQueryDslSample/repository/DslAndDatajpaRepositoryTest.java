package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
@Transactional
public class DslAndDatajpaRepositoryTest {

    @Autowired
    DslAndDatajpaRepository dslAndDatajpaRepository;
    //dslAndDatajpaRepository 하나로 queryDsl과 Spring Data Jpa 함께 사용

    //1. queryDsl 사용
    @Test
    public void 첫번째쿼리() {
        List<Member> memberList = dslAndDatajpaRepository.findByName("userA");
        for (Member member : memberList) {
            System.out.println(member.getName());
        }
    }

    //2. Spring Data Jpa 사용
    @Test
    public void 두번째쿼리() {
        Long id = 1L;
        Member member = dslAndDatajpaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        System.out.println(member.getName());
    }
}
