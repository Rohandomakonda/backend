package com.example.auth_service.repo;

import com.example.auth_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("SELECT u.email FROM User u")
    List<String> getAllUsersByEmail();

    @Query("SELECT u.id FROM User u WHERE u.email = :email")
    Long getUserIdByUsername(@Param("email") String email);

}
