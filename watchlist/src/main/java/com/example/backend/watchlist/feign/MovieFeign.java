package com.example.backend.watchlist.feign;

import com.example.backend.watchlist.DTO.MoviesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="MOVIES-SERVICE")
public interface MovieFeign {
    @GetMapping("/api/movies/{id}")
    ResponseEntity<MoviesDTO> getmoviesbyId(@PathVariable Long id);
}