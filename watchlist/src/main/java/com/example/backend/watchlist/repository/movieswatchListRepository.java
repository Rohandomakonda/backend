package com.example.backend.watchlist.repository;

import com.example.backend.watchlist.models.movieswatchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface movieswatchListRepository extends JpaRepository<movieswatchlist, Long> {
    @Query("SELECT w FROM WatchlistItem w WHERE w.userId = ?1")
    List<movieswatchlist> findByUserId(Long userId);

}


