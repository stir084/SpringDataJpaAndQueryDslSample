package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//QueryDslRepositorySupport를 상속
@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public MemberRepositorySupport(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

    QMember member = QMember.member;

    //1. queryDsl 기본 쿼리
    public List<Member> findByName(String name) {
        return queryFactory.select(member)
                .from(member)
                .where(member.name.eq(name))
                .fetch();
    }

    public List<Member> findByName2(String name) {
        return queryFactory.selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }

    //2. queryDsl 기본 쿼리(조건 2개)
    public List<Member> findByIdAndName(Long Id, String name) {
        return queryFactory.selectFrom(member)
                .where(member.id.eq(Id), member.name.eq(name))
                .fetch();
    }

    //3. queryDsl 기본 쿼리(BooleanExpression)
    public List<Member> findByBoolean(String name) {
        return queryFactory.selectFrom(member)
                .where(nameEq(name))
                .fetch();
    }


    private BooleanExpression nameEq(String name) {
        if(StringUtils.isEmpty(name)){ //deprecated
            return null;
        }
        if(!StringUtils.hasText(name)){
            return null;
        }
        return member.name.eq(name);
    }

}