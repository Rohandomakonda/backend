package com.example.backend.watchlist.service;

import com.example.backend.watchlist.DTO.MoviesDTO;
import com.example.backend.watchlist.feign.MovieFeign;
import com.example.backend.watchlist.models.movieswatchlist;
import com.example.backend.watchlist.repository.movieswatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class watchListService {

    @Autowired
    movieswatchListRepository mwlr;

    @Autowired
    MovieFeign mf;

    public List<MoviesDTO> getmovies(Long profileId) {
        List<movieswatchlist> movies =  mwlr.findByUserId(profileId);
        List<MoviesDTO> listtemp = new ArrayList<>();
        for(movieswatchlist item:movies){
            MoviesDTO mdto = mf.getmoviesbyId(item.getMovieid()).getBody();
            listtemp.add(mdto);
        }
        return listtemp;
    }


}
