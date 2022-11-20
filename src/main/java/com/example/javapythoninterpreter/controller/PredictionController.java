package com.example.javapythoninterpreter.controller;

import com.example.javapythoninterpreter.domain.dto.setUpConfigurationDto;
import com.example.javapythoninterpreter.service.PredictionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    private PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping("/")
    public String index(@RequestBody setUpConfigurationDto board) {
        return predictionService.getPrediction(board.getTowers(), board.getPlayers());
    }
}
