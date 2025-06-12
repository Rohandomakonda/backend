package com.example.backend.watchlist.controller;


import com.example.backend.watchlist.DTO.MoviesDTO;
import com.example.backend.watchlist.models.movieswatchlist;
import com.example.backend.watchlist.service.watchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@CrossOrigin(origins = "*")
public class watchlistController {

    @Autowired
    watchListService wls;

    @GetMapping("/movies/{profileId}")
    private ResponseEntity<?> getmovies(@PathVariable Long profileId){
       List<MoviesDTO> movies = wls.getmovies(profileId);
        System.out.println(profileId);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/movies")
    private ResponseEntity<?> addmoviewatchlist(
            @RequestParam long id,
            @RequestParam long userid,
            @RequestParam long movieid
    ){
        movieswatchlist mitem = new movieswatchlist();
        System.out.println(id+" "+userid+" "+movieid);
        mitem.setId(id);
        mitem.setUserId(userid);
        mitem.setMovieId(movieid);
        movieswatchlist saved = wls.savemovie(mitem);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("movie/{id}")
    private ResponseEntity<?> deletemoviewatchlust(@PathVariable long id){
        long id1 = wls.deletemovie(id);
        return ResponseEntity.ok(id1);
    }
}
