package com.example.Shows.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seriesId;
    private String title;
    private String Description;
    private LocalDate releaseDate;
    private String language;
    private String genres;
    @Column(name = "image")
    private String Thumbnail_url;
}



