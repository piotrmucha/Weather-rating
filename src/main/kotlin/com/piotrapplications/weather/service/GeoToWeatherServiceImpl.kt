package com.piotrapplications.weather.service

import org.json.JSONObject
import org.springframework.stereotype.Service
import java.net.URL
@Service
class GeoToWeatherServiceImpl : GeoToWeatherService {
    companion object Const {
        const val ENDPOINT = "http://api.openweathermap.org/data/2.5/weather"
        const val APPID = "secret"
    }

    override fun getCelsius(coordinates: DoubleArray): Double {
        val url = URL(ENDPOINT + "?lat=" + coordinates[0] + "&lon=" + coordinates[1] + "&units=metric" +"&appid=" + APPID)
        val resultJson = url.readText()
        val jsonObject = JSONObject(resultJson)
        val main = jsonObject.getJSONObject("main")
        val temp = main.getDouble("temp")
        return temp
    }
}