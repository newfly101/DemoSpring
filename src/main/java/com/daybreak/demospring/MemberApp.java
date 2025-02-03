package com.daybreak.demospring;

import com.daybreak.demospring.member.Grade;
import com.daybreak.demospring.member.Member;
import com.daybreak.demospring.member.MemberService;
import com.daybreak.demospring.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("new member = " +  member.getName());
        System.out.println("find member = " +  findmember.getName());
    }
}
