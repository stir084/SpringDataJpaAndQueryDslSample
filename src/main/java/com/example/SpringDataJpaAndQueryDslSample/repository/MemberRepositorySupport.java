package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

//QueryDslRepositorySupport를 상속
@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public MemberRepositorySupport(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

    //1. queryDsl 기본 쿼리
    public List<Member> findByName(String name) {
        QMember member = QMember.member;
        return queryFactory.selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }
}