package com.daybreak.demospring.discount;

import com.daybreak.demospring.member.Grade;
import com.daybreak.demospring.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // Grade는 Enum type이므로 == 써도 된다.
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
