package com.example.backend.watchlist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class movieswatchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long movieId;

    public long getMovieId(){
        return movieId;
    }
    public void setMovieId(long MovieId){
        movieId = MovieId;
    }
    public long getId(){
        return id;
    }
    public void setId(long Id){
        id = Id;
    }
    public long getUserId(){
        return userId;
    }
    public void setUserId(long UserId){
        userId = UserId;
    }
}
