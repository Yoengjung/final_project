package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.DTO.EmailCheckDTO;
import kr.co.teamA.Haru.DTO.UserIdDTO;
import kr.co.teamA.Haru.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // JPA를 사용하여 사용자 ID를 기반으로 UserIdDTO 객체를 조회하는 쿼리
    @Query("SELECT new kr.co.teamA.Haru.DTO.UserIdDTO(m.userId) FROM Member m WHERE m.userId = :userId")
    UserIdDTO findUserIdById(@Param("userId") String userId);
    // 이메일을 기반으로 회원의 존재 유무를 확인하기 위해 COUNT쿼리를 실행하는 메소드
    @Query("SELECT COUNT(m) FROM Member m WHERE m.email = :email")
    int findUserEmailByEmail(@Param("email") String email);
}
