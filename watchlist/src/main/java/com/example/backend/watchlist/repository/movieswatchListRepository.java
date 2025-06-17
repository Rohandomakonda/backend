package com.example.backend.watchlist.repository;

import com.example.backend.watchlist.models.movieswatchlist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movieswatchListRepository extends JpaRepository<movieswatchlist, Long> {
    @Query("SELECT w FROM movieswatchlist w WHERE w.userId = ?1")
    List<movieswatchlist> findByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM movieswatchlist w WHERE w.userId = ?1 AND w.movieId = ?2")
    void deleteByUserIdAndMovieId(Long userId, Long movieId);
}


