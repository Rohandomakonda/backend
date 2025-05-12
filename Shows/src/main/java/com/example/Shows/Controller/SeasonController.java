package com.example.Shows.Controller;


import com.example.Shows.Models.Season;
import com.example.Shows.Models.Series;
import com.example.Shows.Service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    private SeasonService ss;

    @PostMapping("/addseason")
    public ResponseEntity<?> addSeasonRequest(
            @RequestParam int seasonnumber,
            @RequestParam int episodecount,
            @RequestParam String releaseDate, // format: yyyy-MM-dd
            @RequestParam Long seriesid
    ) throws IOException {

        Season season = new Season();
        season.setReleaseDate(LocalDate.parse(releaseDate)); // Ensure format is yyyy-MM-dd
        season.setSeasonNumber(seasonnumber);
        season.setEpisodeCount(episodecount);
        season.setSeries(seriesid);

        Season saved = ss.addSeason(season);
        return ResponseEntity.ok(saved);

    }

}
