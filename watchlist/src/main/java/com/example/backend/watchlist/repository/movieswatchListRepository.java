package com.example.backend.watchlist.repository;

import com.example.backend.watchlist.models.movieswatchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movieswatchListRepository extends JpaRepository<movieswatchlist, Long> {
    @Query("SELECT w FROM movieswatchlist w WHERE w.userId = ?1")
    List<movieswatchlist> findByUserId(Long userId);

}


