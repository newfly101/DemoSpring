package com.daybreak.demospring.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{
    // DB 확정이 되지 않아서 Memory용 test용으로만 사용

    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 문제를 고려한다면 ConcurrentHashMap<>() 을 사용해야 한다.


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
