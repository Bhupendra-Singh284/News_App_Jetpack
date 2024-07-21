package com.example.news_app_jetpack_compose_mvvm.data.manager


import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.news_app_jetpack_compose_mvvm.domain.manager.LocalUserManager
import com.example.news_app_jetpack_compose_mvvm.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LocalUserManagerImp @Inject constructor(
    private val application: Application
): LocalUserManager {
    override suspend fun saveAppEntry() {
          application.datastore.edit { settings->
            settings[PreferenceKeys.APP_ENTRY]=true
        }
    }

    override  fun readAppEntry(): Flow<Boolean> {
        return application.datastore.data.map { preference ->
            preference[PreferenceKeys.APP_ENTRY] ?: false
        }
    }
}

private val Context.datastore:DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferenceKeys{
    val APP_ENTRY= booleanPreferencesKey(Constants.APP_ENTRY)
}