package com.example.news_app_jetpack_compose_mvvm.data.manager


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.news_app_jetpack_compose_mvvm.domain.manager.LocalUserManager
import com.example.news_app_jetpack_compose_mvvm.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserManagerImp @Inject constructor(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
        context.datastore.edit { settings->
            settings[PreferenceKeys.APP_ENTRY]=true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
           return context.datastore.data.map {
                preferences->preferences[PreferenceKeys.APP_ENTRY]?:false
            }
    }


}

private val Context.datastore:DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferenceKeys{
    val APP_ENTRY= booleanPreferencesKey(Constants.APP_ENTRY)
}