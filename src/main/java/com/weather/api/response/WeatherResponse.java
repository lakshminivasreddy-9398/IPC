package com.weather.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponse implements IResponse{
    private String cityName;
    private String countryName;
    private Double lat;
    private Double lon;
    private Double tempInCel;
    private Double tempInFar;
    private Double windSpeedInMph;
    private Double windSpeedInKmph;
    private Double feelsLikeIncel;
    private Double feelsLikeInFar;
}
