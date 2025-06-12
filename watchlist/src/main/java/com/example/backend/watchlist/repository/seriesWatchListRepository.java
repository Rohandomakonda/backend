package com.example.backend.watchlist.repository;

import com.example.backend.watchlist.DTO.SeriesDTO;
import com.example.backend.watchlist.models.serieswatchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface seriesWatchListRepository extends JpaRepository<serieswatchlist,Integer> {
}
