package com.example.jetfrutify.di

import android.content.Context
import com.example.jetfrutify.data.datastore.Datastore
import com.example.jetfrutify.data.datastore.DatastoreImpl
import com.example.jetfrutify.data.repository.remote.RemoteProductRepository
import com.example.jetfrutify.data.repository.remote.RemoteRepository
import com.example.jetfrutify.data.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokeApi(): ApiService {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://frutifyapishapi-v1-qvsopsldnq-uc.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService, datastore: Datastore): RemoteRepository = RemoteRepository(apiService, datastore)

    @Singleton
    @Provides
    fun provideProductRepository(apiService: ApiService, datastore: Datastore): RemoteProductRepository = RemoteProductRepository(apiService, datastore)

    @Singleton
    @Provides
    fun provideDatastore(
        @ApplicationContext context: Context
    ) : Datastore = DatastoreImpl(context)

}