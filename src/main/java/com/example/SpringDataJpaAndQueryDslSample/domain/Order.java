package com.example.SpringDataJpaAndQueryDslSample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]

    public static Order createOrder(Member member){
        Order order = new Order();
        order.addMember(member);
        order.setOrderDate(LocalDateTime.now());
        OrderStatus t = OrderStatus.ORDER;
        order.setStatus(OrderStatus.ORDER);
        return order;
    }

    private void addMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
}
