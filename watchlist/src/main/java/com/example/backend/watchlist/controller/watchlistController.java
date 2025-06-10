package com.example.backend.watchlist.controller;


import com.example.backend.watchlist.DTO.MoviesDTO;
import com.example.backend.watchlist.service.watchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class watchlistController {

    @Autowired
    watchListService wls;

    @GetMapping("/movies/{profileId}")
    private ResponseEntity<?> getmovies(@PathVariable Long profileId){
       List<MoviesDTO> movies = wls.getmovies(profileId);
        return ResponseEntity.ok(movies);
    }
}
