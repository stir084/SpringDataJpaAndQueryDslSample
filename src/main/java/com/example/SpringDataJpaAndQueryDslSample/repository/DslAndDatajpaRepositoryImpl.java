package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DslAndDatajpaRepositoryImpl implements DslAndDatajpaRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    //QuerydslRepositorySupport이 없으므로 그에따른 생성자 필요없음

    QMember member = QMember.member;

    //1. queryDsl 기본 쿼리
    public List<Member> findByName(String name) {
        return queryFactory.selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }
}
