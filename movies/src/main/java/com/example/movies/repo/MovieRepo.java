package com.example.movies.repo;

import com.example.movies.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movies, Integer> {

    @Query("SELECT m FROM Movies m WHERE m.genre = :genre")
    List<Movies> findByGenre(@Param("genre") String genre);
}

