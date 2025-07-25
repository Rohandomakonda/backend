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

import java.util.ArrayList;
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
        System.out.println(series.size());
        List<SeriesDTO> seriesDTOS = new ArrayList<>();
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
            System.out.println(seasonDTOs.size());
            seriesDTO.setSeasons(seasonDTOs);
            seriesDTOS.add(seriesDTO);
        }
        return seriesDTOS;
    }

    public List<SeriesDTO> getallseries() {
        System.out.println("Print");
        List<Series> series=seriesRepository.findAll();
        System.out.println(series.size());
        List<SeriesDTO> seriesDTOS = new ArrayList<>();
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
            System.out.println(seasonDTOs.size());
            seriesDTO.setSeasons(seasonDTOs);
            seriesDTOS.add(seriesDTO);
        }


        return seriesDTOS;
    }
    public SeriesDTO getseriesById(long id) {
        System.out.println("Print");
        Series series=seriesRepository.findBySeriesId(id);

            SeriesDTO seriesDTO = new SeriesDTO();
            seriesDTO.setSeriesId(series.getSeriesId());
            seriesDTO.setTitle(series.getTitle());
            seriesDTO.setDescription(series.getDescription());
            seriesDTO.setReleaseDate(series.getReleaseDate());
            seriesDTO.setLanguage(series.getLanguage());
            seriesDTO.setGenres(series.getGenres());
            seriesDTO.setThumbnailUrl(series.getThumbnail_url());
            List<SeasonDTO> seasonDTOs = seasonService.getseasons(series.getSeriesId());
            System.out.println(seasonDTOs.size());
            seriesDTO.setSeasons(seasonDTOs);



        return seriesDTO;
    }
}
