package com.example.javapythoninterpreter.service.impl;

import com.example.javapythoninterpreter.JavaPythonInterpreterApplication;
import com.example.javapythoninterpreter.service.PredictionService;
import jep.Interpreter;
import jep.SharedInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final Logger logger = LoggerFactory.getLogger(JavaPythonInterpreterApplication.class);

    @Override
    public String getPrediction(int towers, int players) {
        try (Interpreter interp = new SharedInterpreter()) {
            String fileUrlPath = "/Users/luisl/Documents/javaPythonInterpreter/src/main/resources/python";
            interp.exec("import sys");
            interp.exec("sys.path.append('" + fileUrlPath + "')");
            interp.exec("from python import *");

            interp.set("towers", towers);
            interp.set("players", players);
            interp.exec("predicciones = getModelPrediction(towers,players)");

            Object result = interp.getValue("predicciones");
            logger.info("prediction is " + result);
            return (String) result;
        }
    }
}
