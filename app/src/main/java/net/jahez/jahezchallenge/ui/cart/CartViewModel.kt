package net.jahez.jahezchallenge.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CartViewModel() : ViewModel() {

    val title = MutableLiveData("")
    val isFav = MutableLiveData(false)

    init {
        title.value = "Hello World!"
    }

    fun changeTitle() {
        title.value = "Hello Jahez!"
    }



}