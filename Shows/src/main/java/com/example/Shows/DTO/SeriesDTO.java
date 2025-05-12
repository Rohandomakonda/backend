package com.example.Shows.DTO;
import com.example.Shows.DTO.SeasonDTO;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class SeriesDTO {
    private Long seriesId;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String language;
    private String genres;
    private String thumbnailUrl;
    private List<SeasonDTO> seasons;
}
