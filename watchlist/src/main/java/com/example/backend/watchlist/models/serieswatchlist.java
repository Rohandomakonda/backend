package com.example.backend.watchlist.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class serieswatchlist {
    private long userid;
    private long seriesid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
