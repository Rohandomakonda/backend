package com.example.Shows.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seasonid;

    @Column(name = "season_number", nullable = false)
    private int seasonNumber;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "episode_count")
    private int episodeCount;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;



    // Getters and setters

    public Long getSeasonid() {
        return seasonid;
    }

    public void setSeasonid(Long seasonid) {
        this.seasonid = seasonid;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
