package com.weather.api.result;

import lombok.Data;

@Data
public class Current {
    private Long last_updated_epoch;
    private String last_updated;
    private Double temp_c;
    private Double temp_f;

    private Long is_day;

    private Condition condition;
    private double wind_mph;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private double pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double vis_km;
    private double vis_miles;
    private double uv;
    private double gust_mph;
    private double gust_kph;

}
