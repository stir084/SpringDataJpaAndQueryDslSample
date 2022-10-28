package com.example.SpringDataJpaAndQueryDslSample;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * 종 주문 2개
 * * userA
 * 	 * JPA1 BOOK
 * 	 * JPA2 BOOK
 * * userB
 * 	 * SPRING1 BOOK
 * 	 * SPRING2 BOOK
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Member member = createMember("userA");
            Order order = Order.createOrder(member);
            Order order2 = Order.createOrder(member);
            member.getOrders().add(order);
            member.getOrders().add(order2);
            em.persist(member);


        }

        public void dbInit2() {
           /* Member member = createMember("userB");
            em.persist(member);

            Order order = Order.createOrder(member);
            em.persist(order);*/
        }

        private Member createMember(String name) {
            Member member = new Member();
            member.setName(name);
            return member;
        }
    }
}

