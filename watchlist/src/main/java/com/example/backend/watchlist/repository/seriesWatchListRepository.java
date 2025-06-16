package com.example.backend.watchlist.repository;

import com.example.backend.watchlist.models.serieswatchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface seriesWatchListRepository extends JpaRepository<serieswatchlist, Long> {
    List<serieswatchlist> findByUserid(Long userid);
}