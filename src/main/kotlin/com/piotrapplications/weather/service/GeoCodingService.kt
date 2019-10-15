package com.piotrapplications.weather.service

interface GeoCodingService {
    fun getCoordinates(adress: String) : DoubleArray
}