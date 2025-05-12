package com.example.Shows.Repository;

import com.example.Shows.Models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season,Integer> {

    List<Season> findBySeries_SeriesId(Long series_id);

}
