package com.daybreak.demospring.order;

import com.daybreak.demospring.discount.FixDiscountPolicy;
import com.daybreak.demospring.member.Grade;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "member1", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "orderService", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
