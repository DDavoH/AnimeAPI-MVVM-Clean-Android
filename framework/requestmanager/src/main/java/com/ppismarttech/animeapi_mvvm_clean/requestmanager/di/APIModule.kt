package com.ppismarttech.animeapi_mvvm_clean.requestmanager.di

import com.ppismarttech.animeapi_mvvm_clean.requestmanager.APIConstants.BASE_API_URL
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.APIServices
import com.ppismarttech.animeapi_mvvm_clean.requestmanager.datasources.AnimesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIModule {
    
    @Provides
    @Singleton
    fun provideRequestManager(): APIServices {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    
        return Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(APIServices::class.java)
    }
    
    @Provides
    @Singleton
    fun provideAnimeRemoteDataSource(apiServices: APIServices): AnimesRemoteDataSource = AnimesRemoteDataSource(apiServices)
    
}