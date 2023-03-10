package com.weather.api.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidFieldsException extends Exception implements IException{
    private String message;
    private String status;
}
