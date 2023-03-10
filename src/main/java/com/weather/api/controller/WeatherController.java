package com.weather.api.controller;

import com.weather.api.exceptions.IException;
import com.weather.api.exceptions.InvalidFieldsException;
import com.weather.api.response.IResponse;
import com.weather.api.response.WeatherResponse;
import com.weather.api.result.APIResponse;
import com.weather.api.service.IWeatherService;
import com.weather.api.service.WeatherService;
import com.weather.api.validations.WeatherControllerValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private IWeatherService iWeatherService;
    private WeatherControllerValidations validations;

    WeatherController(WeatherService weatherService,WeatherControllerValidations validations)
    {
        this.iWeatherService=weatherService;
        this.validations=validations;
    }
    @GetMapping("/template")
    public ResponseEntity getWeatherByRestTemplate(@RequestParam String city) {
        IException validationResponse = validations.validateField(city);
        if(validationResponse!=null) {
            return new ResponseEntity(validationResponse,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iWeatherService.getWeatherByRestTemplate(city),HttpStatus.OK);
    }
}
