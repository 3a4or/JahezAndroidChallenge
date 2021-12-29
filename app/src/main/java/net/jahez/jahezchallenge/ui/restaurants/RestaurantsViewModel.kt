package net.jahez.jahezchallenge.ui.restaurants

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.jahez.jahezchallenge.base.BaseViewModel
import net.jahez.jahezchallenge.data.entities.RestaurantsResponseItem
import net.jahez.jahezchallenge.data.entities.Result
import net.jahez.jahezchallenge.data.network.BaseRepository
import net.jahez.jahezchallenge.utils.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(private val repo: BaseRepository) : BaseViewModel() {

    var restaurantsList = SingleLiveEvent<List<RestaurantsResponseItem>>()

    fun getRestaurants() {
        viewModelScope.launch {
            dataLoading.value = true
            restaurantsList.value = repo.getRestaurants()
           /* when(val response = repo.getRestaurants()) {
                is Result.Successful -> restaurantsList.value = response.data
                is Result.BaseError -> error.value = response
            }*/
            dataLoading.value = false
        }
    }
}