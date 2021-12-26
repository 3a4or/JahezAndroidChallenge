package net.jahez.jahezchallenge.data.entities

data class RestaurantsResponseItem(
    val distance: Double,
    val hasOffer: Boolean,
    val hours: String,
    val id: Int,
    val image: String,
    val name: String,
    val offer: String?,
    val rating: Double
)