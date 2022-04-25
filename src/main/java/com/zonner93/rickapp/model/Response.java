package com.zonner93.rickapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Response {

    private Info info;
    @JsonProperty("results")
    private List<Episode> episodes = null;
}
