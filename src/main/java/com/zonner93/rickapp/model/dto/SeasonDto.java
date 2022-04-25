package com.zonner93.rickapp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SeasonDto {
    private Integer numberOfEpisodes;
    private List<EpisodeDto> episodes = new ArrayList<>();
}
