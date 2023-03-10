package com.weather.api.service;

import com.weather.api.response.WeatherResponse;

public interface IWeatherService {
    WeatherResponse getWeatherByRestTemplate(String city);
}
