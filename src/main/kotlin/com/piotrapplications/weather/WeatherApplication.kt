package com.piotrapplications.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherApplication

fun main(args: Array<String>) {
    runApplication<WeatherApplication>(*args)
}
