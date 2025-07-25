package com.example.backend.watchlist.feign;

import com.example.backend.watchlist.DTO.SeriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="SHOWS-SERVICE")
public interface SeriesFeign {
    @GetMapping("/api/ss/shows/getseries/{id}")
    ResponseEntity<SeriesDTO> getSeriesById(@PathVariable Long id);
}