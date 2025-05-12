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

    public List<EpisodeDTO> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodeDTO> episodes) {
        this.episodes = episodes;
    }
}
