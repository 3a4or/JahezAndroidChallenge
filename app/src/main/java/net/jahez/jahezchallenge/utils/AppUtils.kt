package net.jahez.jahezchallenge.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import net.jahez.jahezchallenge.MyApp
import java.util.*

object AppUtils {

    private val mainKey = MasterKey.Builder(MyApp.appContext)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val settings: SharedPreferences = EncryptedSharedPreferences.create(
        MyApp.appContext,
        IdManager.SHARED_PREFERENCE,
        mainKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    private val editor : SharedPreferences.Editor = settings.edit()

    fun getFromSharedPreference(key: String): String {
        return settings.getString(key, "") ?: ""
    }

    fun saveInSharedPreference(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun setLanguage(language: String, context: Context) {
        val activityRes = context.resources
        val activityConf = activityRes.configuration
        val newLocale = Locale(language)
        activityConf.setLocale(newLocale)
        activityRes.updateConfiguration(activityConf, activityRes.displayMetrics)

        val applicationRes = context.applicationContext.resources
        val applicationConf = applicationRes.configuration
        applicationConf.setLocale(newLocale)
        applicationRes.updateConfiguration(applicationConf, applicationRes.displayMetrics)
    }

    fun setLanguageWithoutReload(language: String, context: Context) {
        val languageLocale = Locale(language)
        Locale.setDefault(languageLocale)
        val languageConfig = Configuration()
        languageConfig.locale = languageLocale
        context.resources.updateConfiguration(languageConfig, context.resources.displayMetrics)
    }
}