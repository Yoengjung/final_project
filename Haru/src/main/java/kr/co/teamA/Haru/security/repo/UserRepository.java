package kr.co.teamA.Haru.security.repo;

import kr.co.teamA.Haru.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByusername(String username);


}
