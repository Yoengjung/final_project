package com.gambunsa.gambunsaBackend.repository;


import com.gambunsa.gambunsaBackend.model.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members, String> {
    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Members m WHERE m.userId = :userId")
    boolean existsByUserId (@Param("userId") String userId);


}
