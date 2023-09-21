package com.example.jetfrutify.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.datastore: DataStore<Preferences> by preferencesDataStore("USER_PREFERENCES")

class DatastoreImpl @Inject constructor(
    private val context: Context
) : Datastore {
    override suspend fun putString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.datastore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun putInt(key: String, value: Int) {
        val prefKey = intPreferencesKey(key)
        context.datastore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getString(key: String): Flow<String> {
        val prefKey = stringPreferencesKey(key)
        return context.datastore.data.map {
            it[prefKey] ?: "empty"
        }
    }

    override suspend fun getInt(key: String): Flow<Int> {
        val prefKey = intPreferencesKey(key)
        return context.datastore.data.map {
            it[prefKey] ?: 0
        }
    }
}