package com.example.backend.watchlist.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class serieswatchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long userid;
    private long seriesid;

    public Long getId() {
        return id;
    }

    public long getUserid() {
        return userid;
    }

    public long getSeriesid() {
        return seriesid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setSeriesid(long seriesid) {
        this.seriesid = seriesid;
    }
}
