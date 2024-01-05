package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.DTO.UserIdDTO;
import kr.co.teamA.Haru.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    @Query("SELECT new kr.co.teamA.Haru.DTO.UserIdDTO(m.userId) FROM Member m WHERE m.userId = :userId")
    UserIdDTO findUserIdById(@Param("userId") String userId);
}
