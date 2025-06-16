package com.example.backend.watchlist.service;

import com.example.backend.watchlist.DTO.MoviesDTO;
import com.example.backend.watchlist.DTO.SeriesDTO;
import com.example.backend.watchlist.feign.MovieFeign;
import com.example.backend.watchlist.feign.SeriesFeign;
import com.example.backend.watchlist.models.movieswatchlist;
import com.example.backend.watchlist.models.serieswatchlist;
import com.example.backend.watchlist.repository.movieswatchListRepository;
import com.example.backend.watchlist.repository.seriesWatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class watchListService {

    @Autowired
    movieswatchListRepository mwlr;

    @Autowired
    seriesWatchListRepository swlr;

    @Autowired
    MovieFeign mf;

    @Autowired
    SeriesFeign sf;

    // Movie methods
    public List<MoviesDTO> getmovies(Long profileId) {
        List<movieswatchlist> movies = mwlr.findByUserId(profileId);
        List<MoviesDTO> listtemp = new ArrayList<>();
        for(movieswatchlist item : movies){
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

    // Series methods
    public List<SeriesDTO> getseries(Long profileId) {
        List<serieswatchlist> series = swlr.findByUserid(profileId);
        List<SeriesDTO> listtemp = new ArrayList<>();
        for(serieswatchlist item : series){
            SeriesDTO sdto = sf.getseriesbyId(item.getSeriesid()).getBody();
            listtemp.add(sdto);
        }
        return listtemp;
    }

    public serieswatchlist saveseries(serieswatchlist sitem) {
        swlr.save(sitem);
        return sitem;
    }

    public long deleteseries(long id) {
        swlr.deleteById(id);
        return id;
    }
}