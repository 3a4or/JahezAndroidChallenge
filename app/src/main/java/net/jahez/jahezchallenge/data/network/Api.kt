package net.jahez.jahezchallenge.data.network

import net.jahez.jahezchallenge.data.entities.RestaurantsResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("restaurants.json")
    suspend fun getRestaurants(): Response<RestaurantsResponse>
}