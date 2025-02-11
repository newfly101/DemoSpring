package com.daybreak.demospring;

import com.daybreak.demospring.member.Grade;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemberService;
import com.daybreak.demospring.member.MemberServiceImpl;
import com.daybreak.demospring.order.Order;
import com.daybreak.demospring.order.OrderService;
import com.daybreak.demospring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.calculator = " + order.calculatePrice());
    }
}
