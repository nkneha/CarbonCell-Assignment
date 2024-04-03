package com.example.CarbonCellAssignment.repository;

import com.example.CarbonCellAssignment.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Integer> {
    @Query("""
            select t from Token t inner join User u
            on t.user.userId = u.userId
            where t.user.userId = :userId and t.isLogout = false
            """)
    List<Token> findALlTokenByUser(Integer userId);

    Optional<Token> findByToken(String token);


}
