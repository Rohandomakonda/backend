package com.example.auth_service.repo;

import com.example.auth_service.Model.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM Profile p WHERE p.user_id = :userId")
    List<Profile> findByUserId(@Param("userId") Long userId);
}
