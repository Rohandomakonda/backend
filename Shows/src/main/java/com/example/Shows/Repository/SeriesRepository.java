package com.example.Shows.Repository;

import com.example.Shows.Models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer> {
    @Query("SELECT s FROM Series s WHERE LOWER(s.genres) LIKE LOWER(CONCAT('%', :genre, '%'))")
    List<Series> findByGenreContainingIgnoreCase(@Param("genre") String genre);
}
