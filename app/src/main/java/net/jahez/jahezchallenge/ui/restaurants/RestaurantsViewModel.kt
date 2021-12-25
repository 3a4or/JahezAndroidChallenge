package net.jahez.jahezchallenge.ui.restaurants

import dagger.hilt.android.lifecycle.HiltViewModel
import net.jahez.jahezchallenge.base.BaseViewModel
import net.jahez.jahezchallenge.data.network.BaseRepository
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(private val repo: BaseRepository) : BaseViewModel() {


}