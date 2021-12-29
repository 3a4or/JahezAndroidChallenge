package net.jahez.jahezchallenge.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestaurantsResponseItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var distance: Double,
    var hasOffer: Boolean,
    var hours: String,
    var image: String,
    var name: String,
    var offer: String?,
    var rating: Double
)