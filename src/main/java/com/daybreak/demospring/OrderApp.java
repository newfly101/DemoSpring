package com.daybreak.demospring;

import com.daybreak.demospring.member.Grade;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemberService;
import com.daybreak.demospring.member.MemberServiceImpl;
import com.daybreak.demospring.order.Order;
import com.daybreak.demospring.order.OrderService;
import com.daybreak.demospring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculator = " + order.calculatePrice());
    }
}
