package net.jahez.jahezchallenge.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.jahez.jahezchallenge.data.entities.RestaurantsResponseItem

@Database(entities = [RestaurantsResponseItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantsDao

}