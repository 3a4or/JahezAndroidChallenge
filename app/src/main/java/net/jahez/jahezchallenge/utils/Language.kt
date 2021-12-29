package net.jahez.jahezchallenge.utils

object Language {
    fun getLanguage(): String {
        val savedLanguage = AppUtils.getFromSharedPreference(IdManager.APP_LANGUAGE)
        return if (savedLanguage.isEmpty()) {
            // English default language
            "en"
        } else {
            savedLanguage
        }
    }
}