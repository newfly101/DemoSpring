package com.daybreak.demospring.discount;


import com.daybreak.demospring.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
