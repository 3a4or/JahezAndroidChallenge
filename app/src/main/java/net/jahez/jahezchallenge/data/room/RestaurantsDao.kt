package net.jahez.jahezchallenge.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.jahez.jahezchallenge.data.entities.RestaurantsResponseItem

@Dao
interface RestaurantsDao {

    @Query("SELECT * FROM restaurantsResponseItem")
    suspend fun getAllData(): List<RestaurantsResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurantsResponseItem: RestaurantsResponseItem)

}