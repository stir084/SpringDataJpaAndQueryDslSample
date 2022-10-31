package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
@Transactional
public class MemberRepositorySupportTest {

    @Autowired
    MemberRepositorySupport memberRepositorySupport;
    @Test
    public void 첫번째쿼리(){
        List<Member> memberList = memberRepositorySupport.findByName("userA");
        for(Member member : memberList){
            System.out.println(member.getName());
        }
    }

    @Test
    public void 두번째쿼리(){
        List<Member> memberList = memberRepositorySupport.findByIdAndName(1L, "userA");
        for(Member member : memberList){
            System.out.println(member.getName());
        }
    }

    @Test
    public void 세번째쿼리(){
        List<Member> memberList = memberRepositorySupport.findByBoolean("userA");
        for(Member member : memberList){
            System.out.println(member.getName());
        }
    }
}
