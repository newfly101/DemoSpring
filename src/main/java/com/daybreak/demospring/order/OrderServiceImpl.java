package com.daybreak.demospring.order;

import com.daybreak.demospring.discount.DiscountPolicy;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemberRepository;
import com.daybreak.demospring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 구현 객체가 없기 때문에, TEST 진행 시 nullPointException 이 발생하게 됨

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
