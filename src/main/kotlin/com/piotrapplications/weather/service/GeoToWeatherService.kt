package com.piotrapplications.weather.service

interface GeoToWeatherService {
    fun getCelsius(coordinates: DoubleArray) : Double
}