package com.example.Shows.Controller;

import com.example.Shows.Models.Season;
import com.example.Shows.Models.Series;
import com.example.Shows.Service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/shows")
public class SeriesController {

    @Autowired
    private SeriesService ss;
    //get shows by genre
    @GetMapping("/{genre}")
    public ResponseEntity<?> getShowsGenres(@PathVariable String genre){
        return ResponseEntity.ok(ss.getshowsgenre(genre));
    }
    //add shows
    @PostMapping("/addseries")
    public ResponseEntity<?> addSeriesRequest(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String releaseDate, // format: yyyy-MM-dd
            @RequestParam String language,
            @RequestParam String genre,
            @RequestParam String thumbnailUrl
    ) throws IOException{

            Series series = new Series();
            series.setTitle(title);
            series.setDescription(description);
            series.setReleaseDate(LocalDate.parse(releaseDate)); // Ensure format is yyyy-MM-dd
            series.setLanguage(language);
            series.setGenres(genre);
            series.setThumbnail_url(thumbnailUrl);

            Series saved = ss.addSeries(series);
            return ResponseEntity.ok(saved);

    }
    //get all shows
    @GetMapping("/allseries")
    public ResponseEntity<?> getallseries(){
        return ResponseEntity.ok(ss.getallseries());
    }
}

