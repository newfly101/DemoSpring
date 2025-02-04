package com.daybreak.demospring.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 실제 할당 부분이 구현체를 의존함 (추상화. 구체화에 의존)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // TEST 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
