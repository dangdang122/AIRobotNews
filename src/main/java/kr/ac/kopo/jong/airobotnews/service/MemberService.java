package kr.ac.kopo.jong.airobotnews.service;

import kr.ac.kopo.jong.airobotnews.domain.Member;
import kr.ac.kopo.jong.airobotnews.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member register(String email, String password) {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        return memberRepository.save(member);
    }

    public Member login(String email, String password) {
        return memberRepository.findByEmail(email)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}