package com.example.movies.controller;

import com.example.movies.Model.Movies;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class moviesrequest {
    @Autowired
    private MovieService movieservice;



    // getmovue by genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity<?> getmoviesbygenre(@PathVariable String genre){
        return ResponseEntity.ok(movieservice.getmoviesgenre(genre));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>> getmoviesbyId(@PathVariable Long id){
        return ResponseEntity.ok(movieservice.getmoviesid(id));
    }


    //add movies
    @PostMapping("/addmovie")
    public ResponseEntity<?> addmovierequest(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String releaseDate, // we'll parse this
            @RequestParam Integer duration,
            @RequestParam String genre,
            @RequestParam String language,
            @RequestParam Double rating,
            @RequestParam("video") MultipartFile videoFile,
            @RequestParam String thumbnailUrl
    ) throws IOException {

        Movies movie = new Movies();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setReleaseDate(LocalDate.parse(releaseDate)); // Ensure format is yyyy-MM-dd
        movie.setDuration(duration);
        movie.setGenre(genre);
        movie.setLanguage(language);
        movie.setRating(rating);
        movie.setVideoData(videoFile.getBytes());
        movie.setThumbnailUrl(thumbnailUrl);

        Movies saved=movieservice.addMovie(movie);
        return ResponseEntity.ok(saved);
    }



    //get all movies
    @GetMapping("/allmovies")
    public ResponseEntity<?> getallmovies(){
        return ResponseEntity.ok(movieservice.getallmovies());
    }





}
