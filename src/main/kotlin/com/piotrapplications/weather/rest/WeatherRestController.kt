package com.piotrapplications.weather.rest

import com.piotrapplications.weather.service.GeoCodingService
import com.piotrapplications.weather.service.GeoToWeatherService
import com.piotrapplications.weather.service.WeatherRatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherRestController {
    @Autowired
    lateinit var  geoCoding : GeoCodingService
    @Autowired
    lateinit var  geoToWeather: GeoToWeatherService
    @Autowired
    lateinit var  weatherRating : WeatherRatingService
    @GetMapping("/adress")
    @ResponseBody
    fun getAnswer(@RequestParam(required = true)input: String): String {
            val arrayCoordinates = geoCoding.getCoordinates(input)
            val temperature = geoToWeather.getCelsius(arrayCoordinates)
            return weatherRating.getRating(temperature)
    }
}