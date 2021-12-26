package net.jahez.jahezchallenge.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.jahez.jahezchallenge.data.entities.Result

open class BaseViewModel : ViewModel() {

    val dataLoading = MutableLiveData(false)

    var error = MutableLiveData<Result.BaseError>()
}