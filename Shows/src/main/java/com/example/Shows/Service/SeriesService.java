package com.example.Shows.Service;

import com.example.Shows.DTO.SeasonDTO;
import com.example.Shows.DTO.SeriesDTO;
import com.example.Shows.Models.Episode;
import com.example.Shows.Models.Season;
import com.example.Shows.Models.Series;
import com.example.Shows.Repository.EpisodeRepository;
import com.example.Shows.Repository.SeasonRepository;
import com.example.Shows.Repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private SeasonService seasonService;

    public Series addSeries(Series series) {
        System.out.println("hello1");
        seriesRepository.save(series);
        return series;
    }

    public List<SeriesDTO> getshowsgenre(String genre) {
        List<Series> series=seriesRepository.findByGenreContainingIgnoreCase(genre);
        List<SeriesDTO> seriesDTOS = List.of();
        for(Series s: series){
            SeriesDTO seriesDTO = new SeriesDTO();
            seriesDTO.setSeriesId(s.getSeriesId());
            seriesDTO.setTitle(s.getTitle());
            seriesDTO.setDescription(s.getDescription());
            seriesDTO.setReleaseDate(s.getReleaseDate());
            seriesDTO.setLanguage(s.getLanguage());
            seriesDTO.setGenres(s.getGenres());
            seriesDTO.setThumbnailUrl(s.getThumbnail_url());
            List<SeasonDTO> seasonDTOs = seasonService.getseasons(s.getSeriesId());
            seriesDTO.setSeasons(seasonDTOs);
        }
        return seriesDTOS;
    }

    public Object getallseries() {
        System.out.println("Print");
        return seriesRepository.findAll();
    }
}
