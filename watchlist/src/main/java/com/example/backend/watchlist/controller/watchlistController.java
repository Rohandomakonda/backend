package com.example.backend.watchlist.controller;

import com.example.backend.watchlist.DTO.MoviesDTO;
import com.example.backend.watchlist.DTO.SeriesDTO;
import com.example.backend.watchlist.models.movieswatchlist;
import com.example.backend.watchlist.models.serieswatchlist;
import com.example.backend.watchlist.service.watchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@CrossOrigin(origins = "*")
public class watchlistController {

    @Autowired
    watchListService wls;

    // Movie endpoints
    @GetMapping("/movies/{profileId}")
    public ResponseEntity<List<MoviesDTO>> getmovies(@PathVariable Long profileId){
        List<MoviesDTO> movies = wls.getmovies(profileId);
        System.out.println("Getting movies for profile: " + profileId);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/movies")
    public ResponseEntity<movieswatchlist> addmoviewatchlist(
            @RequestParam(required = false) Long id,
            @RequestParam long userid,
            @RequestParam long movieid
    ){
        movieswatchlist mitem = new movieswatchlist();
        System.out.println("Received request to add movie: ID=" + id + ", UserId=" + userid + ", MovieId=" + movieid);
        if (id != null) {
            mitem.setId(id);
        }
        mitem.setUserId(userid);
        mitem.setMovieId(movieid);
        movieswatchlist saved = wls.savemovie(mitem);
        System.out.println("Movie watchlist entry saved with ID: " + saved.getId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Long> deletemoviewatchlist(@PathVariable long id){
        System.out.println("Attempting to delete movie watchlist entry with ID: " + id);
        long deletedId = wls.deletemovie(id);
        System.out.println("Movie watchlist entry deleted with ID: " + deletedId);
        return ResponseEntity.ok(deletedId);
    }

    // Series endpoints
    @GetMapping("/series/{profileId}")
    public ResponseEntity<List<SeriesDTO>> getseries(@PathVariable Long profileId){
        List<SeriesDTO> series = wls.getseries(profileId);
        System.out.println("Getting series for profile: " + profileId);
        return ResponseEntity.ok(series);
    }

    @PostMapping("/series")
    public ResponseEntity<serieswatchlist> addserieswatchlist(
            @RequestParam(required = false) Long id,
            @RequestParam long userid,
            @RequestParam long seriesid
    ){
        serieswatchlist sitem = new serieswatchlist();
        System.out.println("Received request to add series: ID=" + id + ", UserId=" + userid + ", SeriesId=" + seriesid);
        if (id != null) {
            sitem.setId(id);
        }
        sitem.setUserid(userid);
        sitem.setSeriesid(seriesid);
        serieswatchlist saved = wls.saveseries(sitem);
        System.out.println("Series watchlist entry saved with ID: " + saved.getId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/series/{id}")
    public ResponseEntity<Long> deleteserieswatchlist(@PathVariable long id){
        System.out.println("Attempting to delete series watchlist entry with ID: " + id);
        long deletedId = wls.deleteseries(id);
        System.out.println("Series watchlist entry deleted with ID: " + deletedId);
        return ResponseEntity.ok(deletedId);
    }
}