package com.example.backend.watchlist.repository;

import com.example.backend.watchlist.models.serieswatchlist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface seriesWatchListRepository extends JpaRepository<serieswatchlist, Long> {
    List<serieswatchlist> findByUserid(Long userid);

    @Modifying
    @Transactional
    @Query("DELETE FROM serieswatchlist s WHERE s.userid = ?1 AND s.seriesid = ?2")
    void deleteByUseridAndSeriesid(Long userid, Long seriesid);
}