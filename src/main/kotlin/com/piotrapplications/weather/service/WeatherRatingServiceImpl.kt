package com.piotrapplications.weather.service

import org.springframework.stereotype.Service

@Service
class WeatherRatingServiceImpl : WeatherRatingService {
    override fun getRating(temperature: Double): String = when {
            temperature < 15 ->   "it's cold, take your jacket"
            else ->  "the weather is good, leave your jacket at home"
        }

    }
