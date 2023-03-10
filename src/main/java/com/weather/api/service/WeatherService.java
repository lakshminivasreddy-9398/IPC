package com.weather.api.service;

import com.google.gson.Gson;
import com.weather.api.response.WeatherResponse;
import com.weather.api.result.APIResponse;
import com.weather.api.result.Current;
import com.weather.api.result.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService implements IWeatherService{

    private String weatherBaseUrl;
    private String weatherApiKey;
    private  RestTemplate restTemplate;

    WeatherService(Environment environment)
    {
        this.weatherApiKey=environment.getProperty("weather.api.key");
        this.weatherBaseUrl=environment.getProperty("weather.api.url");
       this.restTemplate =new RestTemplate();
    }
    @Override
    public WeatherResponse getWeatherByRestTemplate(String city) {
        String url=weatherBaseUrl+"?key="+weatherApiKey+"&q="+city;

        String responseJson=restTemplate.getForObject(url, String.class);
        Gson gson=new Gson();
        APIResponse apiResult = gson.fromJson(responseJson, APIResponse.class);
        Current current = apiResult.getCurrent();
        Location location = apiResult.getLocation();
        WeatherResponse weatherResponse=new WeatherResponse(location.getName(),location.getCountry(),
                location.getLat(),location.getLon(),
                current.getTemp_c(),current.getTemp_f(),
                current.getWind_mph(),current.getWind_kph(),
                current.getFeelslike_c(),current.getFeelslike_f());
        return weatherResponse;
    }
}
