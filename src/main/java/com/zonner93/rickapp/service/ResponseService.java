package com.zonner93.rickapp.service;

import com.zonner93.rickapp.model.Info;
import com.zonner93.rickapp.model.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ResponseService {
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public Response getResponse() {

        Response response = restTemplate.getForObject("https://rickandmortyapi.com/api/episode", Response.class);

        return response;
    }

    public Info getInfo() {

        Response response = getResponse();
        Info i = response.getInfo();

        return modelMapper.map(i, Info.class);
    }
}
