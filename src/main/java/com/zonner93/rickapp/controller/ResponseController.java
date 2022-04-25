package com.zonner93.rickapp.controller;

import com.zonner93.rickapp.model.Response;
import com.zonner93.rickapp.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping(path = "/")
    public Response getResponse() {
        return responseService.getResponse();
    }
}
