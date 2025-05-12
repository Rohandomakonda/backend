package com.example.Shows.Controller;

import com.example.Shows.Service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class SeriesController {

    @Autowired
    private SeriesService ss;
    //get shows by genre
    @GetMapping("/{genre}")
    public ResponseEntity<?> getShowsGenres(@PathVariable String genre){
        return ResponseEntity.ok(ss.getshowsgenre(genre));
    }
    //add shows
    //get all shows

}

