package com.daybreak.demospring;

import com.daybreak.demospring.discount.DiscountPolicy;
import com.daybreak.demospring.discount.FixDiscountPolicy;
import com.daybreak.demospring.discount.RateDiscountPolicy;
import com.daybreak.demospring.member.MemberRepository;
import com.daybreak.demospring.member.MemberService;
import com.daybreak.demospring.member.MemberServiceImpl;
import com.daybreak.demospring.member.MemoryMemberRepository;
import com.daybreak.demospring.order.OrderService;
import com.daybreak.demospring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

}
