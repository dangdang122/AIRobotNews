package kr.ac.kopo.jong.airobotnews.repository;

import kr.ac.kopo.jong.airobotnews.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}