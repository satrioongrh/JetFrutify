package com.example.jetfrutify.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
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

    override suspend fun putBoolean(key: String, value: Boolean) {
        val prefKey = booleanPreferencesKey(key)
        context.datastore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getString(key: String): String? {
        val prefKey = stringPreferencesKey(key)
        val prefeerence = context.datastore.data.first()
        return prefeerence[prefKey]
    }

    override suspend fun getInt(key: String): Int? {
        val prefKey = intPreferencesKey(key)
        val prefeerence = context.datastore.data.first()
        return prefeerence[prefKey]
    }

    override suspend fun getBoolean(key: String): Boolean? {
        val prefKey = booleanPreferencesKey(key)
        val prefeerence = context.datastore.data.first()
        return prefeerence[prefKey]
    }

    override suspend fun clearPref(key: String) {
        val prefKey = stringPreferencesKey(key)
        context.datastore.edit {
            if (it.contains(prefKey)){
                it.remove(prefKey)
            }
        }
    }


}