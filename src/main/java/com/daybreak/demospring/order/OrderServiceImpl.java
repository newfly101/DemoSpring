package com.daybreak.demospring.order;

import com.daybreak.demospring.discount.DiscountPolicy;
import com.daybreak.demospring.discount.FixDiscountPolicy;
import com.daybreak.demospring.discount.RateDiscountPolicy;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemberRepository;
import com.daybreak.demospring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // TODO : 문제점 => OCP를 위반

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
