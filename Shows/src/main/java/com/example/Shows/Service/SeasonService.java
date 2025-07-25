package com.example.Shows.Service;

import com.example.Shows.DTO.EpisodeDTO;
import com.example.Shows.DTO.SeasonDTO;
import com.example.Shows.Models.Season;
import com.example.Shows.Models.Series;
import com.example.Shows.Repository.SeasonRepository;
import com.example.Shows.Service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeService episodeService;

    public List<SeasonDTO> getseasons(Long seriesid){
        List<Season> seasons = seasonRepository.findBySeriesId(seriesid);
        List<SeasonDTO> seasonDTOS = new ArrayList<>();
        for(Season season:seasons){
            SeasonDTO seasonDTO = new SeasonDTO();
            seasonDTO.setSeasonid(season.getSeasonId());
            seasonDTO.setSeasonNumber(season.getSeasonNumber());
            seasonDTO.setReleaseDate(season.getReleaseDate());
            seasonDTO.setEpisodeCount(season.getEpisodeCount());
            List<EpisodeDTO> episodeDTOs = episodeService.getallepisodes(season.getSeasonId());
            seasonDTO.setEpisodes(episodeDTOs);
            seasonDTOS.add(seasonDTO);
        }
        return seasonDTOS;
    }

    public Season addSeason(Season season) {
        seasonRepository.save(season);
        return season;
    }
}
