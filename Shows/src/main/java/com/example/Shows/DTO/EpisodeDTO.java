package com.example.Shows.DTO;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EpisodeDTO {
    private Long id;
    private String title;
    private int episodeNumber;
    private int duration;
    private LocalDate releaseDate;
    private String thumbnailUrl;
    private byte[] fileUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public byte[] getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(byte[] fileUrl) {
        this.fileUrl = fileUrl;
    }
}
