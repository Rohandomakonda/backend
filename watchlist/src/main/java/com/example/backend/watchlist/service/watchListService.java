package com.example.backend.watchlist.service;

import com.example.backend.watchlist.DTO.MoviesDTO;
import com.example.backend.watchlist.feign.MovieFeign;
import com.example.backend.watchlist.models.movieswatchlist;
import com.example.backend.watchlist.repository.movieswatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class watchListService {

    @Autowired
    movieswatchListRepository mwlr;

    @Autowired
    MovieFeign mf;

    public List<MoviesDTO> getmovies(Long profileId) {
        List<movieswatchlist> movies =  mwlr.findByUserId(profileId);
        List<MoviesDTO> listtemp = new ArrayList<>();
        for(movieswatchlist item:movies){
            MoviesDTO mdto = mf.getmoviesbyId(item.getMovieId()).getBody();
            listtemp.add(mdto);
        }
        return listtemp;
    }


    public movieswatchlist savemovie(movieswatchlist mitem) {
        mwlr.save(mitem);
        return mitem;
    }

    public long deletemovie(long id) {
        mwlr.deleteById(id);
        return id;
    }
}
