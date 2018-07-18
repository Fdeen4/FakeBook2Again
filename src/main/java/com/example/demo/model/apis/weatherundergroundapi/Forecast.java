package com.example.demo.model.apis.weatherundergroundapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private Instant dt;
    private Map<String, Double> temp;
    private Double pressure;
    private Double humidity;
    private List<Map<String, String>> weather;
    private Double speed;
    private Integer deg;
    private Integer clouds;

    public Forecast() {
        weather = new ArrayList<>();
    }

    public String getDt() {
        return dt.toString();
    }

    public void setDt(String dt) {
        this.dt = Instant.ofEpochMilli(new Long(dt));
    }

    public Map<String, Double> getTemp() {
        return temp;
    }

    public void setTemp(Map<String, Double> temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public List<Map<String, String>> getWeather() {
        return weather;
    }

    public void setWeather(List<Map<String, String>> weather) {
        this.weather = weather;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weather=" + weather +
                ", speed=" + speed +
                ", deg=" + deg +
                ", clouds=" + clouds +
                '}';
    }
}
