package com.example.demo.model.apis.weatherundergroundapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecasts {
    private List<Forecast> list;

    public Forecasts() {
        list = new ArrayList<>();
    }

    public List<Forecast> getList() {
        return list;
    }

    public void setList(List<Forecast> list) {
        this.list = list;
    }
}
