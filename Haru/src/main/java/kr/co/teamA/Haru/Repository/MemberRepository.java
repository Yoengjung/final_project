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
    @Query("SELECT new kr.co.teamA.Haru.DTO.UserIdDTO(m.userId) FROM Member m WHERE m.userId = :userId")
    UserIdDTO findUserIdById(@Param("userId") String userId);

    @Query("SELECT COUNT(m) FROM Member m WHERE m.email = :email")
    int findUserEmailByEmail(@Param("email") String email);
}
