package com.example.Shows.Repository;

import com.example.Shows.Models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {

    List<Episode> findBySeasonId(Long seasonId);

}
