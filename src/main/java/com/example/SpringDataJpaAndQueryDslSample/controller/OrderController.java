package com.example.SpringDataJpaAndQueryDslSample.controller;

import com.example.SpringDataJpaAndQueryDslSample.domain.Member;
import com.example.SpringDataJpaAndQueryDslSample.service.MemberService;
import com.example.SpringDataJpaAndQueryDslSample.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;


    @GetMapping("/order")
    public String createForm(Model model) {

/*        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members);*/

        return "order/orderForm";
    }
}
