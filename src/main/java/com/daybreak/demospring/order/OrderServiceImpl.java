package com.daybreak.demospring.order;

import com.daybreak.demospring.discount.DiscountPolicy;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // TEST 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
