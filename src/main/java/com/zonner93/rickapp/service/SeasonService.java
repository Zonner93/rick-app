package com.zonner93.rickapp.service;

import com.zonner93.rickapp.model.Episode;
import com.zonner93.rickapp.model.Info;
import com.zonner93.rickapp.model.Season;
import com.zonner93.rickapp.model.dto.EpisodeDto;
import com.zonner93.rickapp.model.dto.SeasonDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final ModelMapper modelMapper;
    private final EpisodeService episodeService;

    public int getNumberOfSeasons(Info info) {

        int counter = info.getCount();
        int numberOfSeasons = 0;

        String last = episodeService.getSingleEpisode(counter).getEpisode();

        numberOfSeasons = Integer.parseInt(last.substring(last.indexOf('S') + 1, last.indexOf('E')));

        return numberOfSeasons;
    }

    public List<SeasonDto> getAllSeasonsWithNumberOfEpisodes(Info info) {

        int counter = getNumberOfSeasons(info);

        List<SeasonDto> seasons = new ArrayList<>();

        for (int i = 1; i <= counter; i++) {

            seasons.add(getAllEpisodesOfSingleSeason(i));
        }
        return seasons;
    }

    public SeasonDto getAllEpisodesOfSingleSeason(int id) {

        Season season = new Season(id);

        String currentSeason = "";

        if (id < 10) {
            currentSeason = "S0" + id + "E";
        } else {
            currentSeason = "S" + id + "E";
        }

        List<EpisodeDto> episodes = episodeService.getAllEpisodes();

        int numberOfAllEpisodes = episodes.size();

        for (int i = 0; i < numberOfAllEpisodes; i++) {

            String seasonOfEpisode = episodes.get(i).getEpisode();

            if (seasonOfEpisode.contains(currentSeason)) {

                season.addEpisode(modelMapper.map(episodes.get(i), Episode.class));
            }
        }

        season.setNumberOfEpisodes(season.getEpisodes().size());

        return modelMapper.map(season, SeasonDto.class);
    }
}
