package com.example.Shows.Controller;

import com.example.Shows.Models.Episode;
import com.example.Shows.Models.Season;
import com.example.Shows.Models.Series;
import com.example.Shows.Repository.EpisodeRepository;
import com.example.Shows.Service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    @Autowired
    private EpisodeService episodeservice;

    @PostMapping("/addepisode")
    public ResponseEntity<?> addEpisodeRequest(
            @RequestParam int duration,
            @RequestParam int episodeNumber,
            @RequestParam String releaseDate,
            @RequestParam String title,
            @RequestParam Long seasonId,
            @RequestParam String thumbnailUrl,
            @RequestParam("video") MultipartFile fileUrl
    ) throws IOException {

        Episode episode = new Episode();
        episode.setReleaseDate(LocalDate.parse(releaseDate)); // Ensure format is yyyy-MM-dd
        episode.setDuration(duration);
        episode.setEpisodeNumber(episodeNumber);
        episode.setSeasonId(seasonId);
        episode.setTitle(title);
        episode.setThumbnailUrl(thumbnailUrl);
        episode.setFileUrl(fileUrl.getBytes());


        Episode saved = episodeservice.addEpisode(episode);
        return ResponseEntity.ok(saved);

    }




}
