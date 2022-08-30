package jpa.jpa_study.jpa.jpaShop.service;

import jpa.jpa_study.jpa.jpaShop.api.dto.QueryDto;
import jpa.jpa_study.jpa.jpaShop.domain.Member;
import jpa.jpa_study.jpa.jpaShop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    @Transactional
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QueryDto> findDto() {
        return memberRepository.findMemberDto();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
}
