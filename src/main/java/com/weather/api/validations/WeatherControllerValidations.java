package com.weather.api.validations;

import com.weather.api.exceptions.IException;
import com.weather.api.exceptions.InvalidFieldsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherControllerValidations {

    public IException validateField(String field)
    {
        return field.isBlank()||field.isEmpty()?new InvalidFieldsException("Invalid Feild : "+field, HttpStatus.BAD_REQUEST.toString()):null;
    }
}
