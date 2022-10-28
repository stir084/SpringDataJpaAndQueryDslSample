package com.example.SpringDataJpaAndQueryDslSample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    //private final OrderRepository orderRepository;
    //private final MemberRepository memberRepository;

    @Transactional
    public void order(){
/*
        Member member = memberRepository.findOne(orderForm.getMemberId());

        //배송정보
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, orderForm.getCount() * item.getPrice(), orderForm.getCount());

        //주문 생성
        Order order = Order.createOrder(member);

        orderRepository.save(order);*/
    }

}
