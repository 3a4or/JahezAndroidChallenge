package net.jahez.jahezchallenge.ui.settings

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import net.jahez.jahezchallenge.base.BaseViewModel
import net.jahez.jahezchallenge.data.entities.SpinnerItemModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : BaseViewModel() {

    val languages = MutableLiveData<MutableList<SpinnerItemModel>>(mutableListOf())
    val selectedLang = MutableLiveData<SpinnerItemModel>()
}