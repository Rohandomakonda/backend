package com.example.movies.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Integer duration;

    private String genre;

    private String language;

    private Double rating;

    @Lob
    @Column(name = "video")
    private byte[] videoData;  // This stores the actual MP4 binary

    @Column(name = "image")
    private String thumbnailUrl;

}