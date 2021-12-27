package net.jahez.jahezchallenge.data.entities

import net.jahez.jahezchallenge.utils.Language

data class SpinnerItemModel (
    val id: Int,
    val valueAr: String,
    val valueEn: String,
    var key: String = ""
){
    override fun toString(): String {
        return if (Language.getLanguage() == "ar"){
            valueAr
        } else {
            valueEn
        }
    }
}