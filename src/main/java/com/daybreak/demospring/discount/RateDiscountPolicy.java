package com.daybreak.demospring.discount;

import com.daybreak.demospring.member.Grade;
import com.daybreak.demospring.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
//            return price * (100 - discountPercent) / 100;
        } else {
            return 0;
        }
    }
}
