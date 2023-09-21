package com.example.jetfrutify.data.datastore

import kotlinx.coroutines.flow.Flow

interface Datastore {

    suspend fun putString(key: String, value: String)
    suspend fun putInt(key: String, value: Int)

    suspend fun getString(key: String) : Flow<String>
    suspend fun getInt(key: String) : Flow<Int>


}