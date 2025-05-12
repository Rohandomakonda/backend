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
}
