package com.example.Shows.DTO;
import com.example.Shows.DTO.EpisodeDTO;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class SeasonDTO {
    private Long seasonid;
    private int seasonNumber;
    private LocalDate releaseDate;
    private int episodeCount;
    private List<EpisodeDTO> episodes;
}
