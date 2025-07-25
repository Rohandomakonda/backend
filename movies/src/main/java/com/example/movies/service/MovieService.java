package com.example.movies.service;

import com.example.movies.Model.Movies;
import com.example.movies.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
   private MovieRepo movierepo;


    public List<Movies> getmoviesgenre(String genre) {
        System.out.println("hello"); // ✅ Correct
        return movierepo.findByGenre(genre);
    }
    public Optional<Movies> getmoviesid(Long id) {
        return movierepo.findById(id);
    }

    public Movies addMovie(Movies movie) {
        System.out.println("hello1");
        movierepo.save(movie);
        return movie;
    }

    public List<Movies> getallmovies() {
        System.out.println("All movies found");
        return movierepo.findAll();
    }
}
