package com.example.Shows.Service;

import com.example.Shows.DTO.EpisodeDTO;
import com.example.Shows.Models.Episode;
import com.example.Shows.Repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public List<EpisodeDTO> getallepisodes(Long seasonid){
        List<Episode> episodes= episodeRepository.findBySeasonId(seasonid);
        List<EpisodeDTO> episodeDTOS = new ArrayList<>();
        for(Episode ep:episodes){
            EpisodeDTO epdto = new EpisodeDTO();
            epdto.setId(ep.getId());
            epdto.setEpisodeNumber(ep.getEpisodeNumber());
            epdto.setDuration(ep.getDuration());
            epdto.setTitle(ep.getTitle());
            epdto.setFileUrl(ep.getFileUrl());
            epdto.setThumbnailUrl(ep.getThumbnailUrl());
            epdto.setReleaseDate(ep.getReleaseDate());
            episodeDTOS.add(epdto);
        }
        return episodeDTOS;
    }

    public Episode addEpisode(Episode episode) {
        episodeRepository.save(episode);
        return episode;
    }
}
