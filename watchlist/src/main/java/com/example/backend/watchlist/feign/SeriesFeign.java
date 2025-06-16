package com.example.backend.watchlist.feign;

import com.example.backend.watchlist.DTO.SeriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="SERIES-SERVICE")
public interface SeriesFeign {
    @GetMapping("/api/series/{id}")
    ResponseEntity<SeriesDTO> getseriesbyId(@PathVariable Long id);
}