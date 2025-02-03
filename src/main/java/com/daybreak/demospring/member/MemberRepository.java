package com.daybreak.demospring.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
