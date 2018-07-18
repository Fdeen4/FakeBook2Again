package com.example.demo.services;

import com.example.demo.model.apis.weatherundergroundapi.Forecast;
import com.example.demo.model.apis.weatherundergroundapi.Forecasts;
import com.example.demo.model.auth.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    AppUserRepository users;

    public Forecasts forecasts(){
        RestTemplate fromApi = new RestTemplate();
        Forecasts forecasts = fromApi.getForObject(apiUrlByZipCode("20910"), Forecasts.class);//zip code should come from the user...

        return forecasts;
    }

    public String apiUrlByZipCode(String zipcode){
        return "https://samples.openweathermap.org/data/2.5/forecast/daily?zip=" + zipcode + "&appid=b6907d289e10d714a6e88b30761fae22";
    }

    @Override
    public String toString(){//for testing
        String weatherText = "";
        for (Forecast forecast : forecasts().getList()){
            weatherText += forecast.toString() + "\n\n";
        }
        return weatherText;
    }
}
