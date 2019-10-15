package com.piotrapplications.weather.service
import org.springframework.stereotype.Service
import java.net.URL
import org.json.*
import java.net.URLEncoder
@Service
class GeoCodingServiceImpl : GeoCodingService {
    companion object Const {
        const val ENDPOINT = "https://maps.googleapis.com/maps/api/geocode/json"
        const val KEY = "secret"
    }
    override fun getCoordinates(adress: String): DoubleArray {
        val url = URL(ENDPOINT + "?address=" + URLEncoder.encode(adress, "UTF-8") + "&key=" + KEY)
        val resultJson = url.readText()
        val jsonObject = JSONObject(resultJson)
        val jsonArray = jsonObject.getJSONArray("results")
        val firstObject = jsonArray.getJSONObject(0)
        val secondObject = firstObject.getJSONObject("geometry")
        val geometry = secondObject.getJSONObject("location")
        val firstVal = geometry.getDouble("lat")
        val secondVal = geometry.getDouble("lng")
        return doubleArrayOf(firstVal,secondVal)
    }
}