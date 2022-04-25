package com.zonner93.rickapp.controller;

import com.zonner93.rickapp.model.dto.SeasonDto;
import com.zonner93.rickapp.service.ResponseService;
import com.zonner93.rickapp.service.SeasonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/season")
public class SeasonController {

    private final SeasonService seasonService;
    private final ResponseService responseService;

    @GetMapping(path = "/")
    public List<SeasonDto> getAllSeasons() {
        return seasonService.getAllSeasonsWithNumberOfEpisodes(responseService.getInfo());
    }

    @GetMapping(path = "/{id}")
    public SeasonDto getEpisodesOfSingleSeason(@PathVariable("id") int id) {

        return seasonService.getAllEpisodesOfSingleSeason(id);
    }

    @GetMapping(path = "/count")
    public int getNumberOfSeasons() {

        return seasonService.getNumberOfSeasons(responseService.getInfo());
    }
}
