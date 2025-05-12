package com.example.Shows.Models;

import com.example.Shows.Models.Season;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    private String title;

    @Column(name = "episode_number", nullable = false)
    private int episodeNumber;

    private int duration;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Lob
    @Column(name = "video")
    private byte[] fileUrl;

    @Column(name = "image")
    private String thumbnailUrl;

    // Getters and setters
}
