package com.piotrapplications.weather.service

interface WeatherRatingService {
    fun getRating(temperature: Double): String
}