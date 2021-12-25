package net.jahez.jahezchallenge.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val dataLoading = MutableLiveData(false)

    var error = MutableLiveData<String>()
}