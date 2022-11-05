package com.example.SpringDataJpaAndQueryDslSample.repository;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.QMember;
import com.example.SpringDataJpaAndQueryDslSample.domain.QOrder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.SpringDataJpaAndQueryDslSample.domain.QOrder.order;

//QueryDslRepositorySupport를 상속
@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public MemberRepositorySupport(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

    QMember member = QMember.member;
    // QOrder order = QOrder.order; 이 부분도 생략해서 Static으로 Import 가능

    //1. queryDsl 기본 쿼리
    public List<Member> findByName(String name) {
        return queryFactory.select(member)
                .from(member)
                .where(member.name.eq(name))
                .fetch();
    }

    //1-1. selectFrom 같이 쓰기
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

    //2-1. queryDsl 기본 쿼리(조건 2개)
    public List<Member> findByIdAndName2(Long Id, String name) {
        return queryFactory.selectFrom(member)
                .where(member.id.eq(Id).and(member.name.eq(name)))
                .fetch();
    }

    //3. BooleanExpression
    public List<Member> findByBoolean(String name) {
        return queryFactory.selectFrom(member)
                .where(nameEq(name))
                .fetch();
    }

    //4. Join과 Where은 같은 의미?
    public List<Member> findJoinAndWhere(String name) {
        if(true){
            return queryFactory.select(member)
                    .from(member)
                    .where(member.orders.get(0).id.eq(1L))
                    .fetch();
        }
        return queryFactory.select(member)
                .from(member.orders, order)
                .where(order.id.eq(1L))
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