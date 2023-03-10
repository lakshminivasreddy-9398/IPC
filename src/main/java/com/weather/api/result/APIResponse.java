package com.weather.api.result;

import lombok.Data;

@Data
public class APIResponse {
    public Location location;
    public Current current;
}
