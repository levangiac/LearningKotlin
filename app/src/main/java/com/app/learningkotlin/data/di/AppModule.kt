package com.app.learningkotlin.data.di

import com.app.learningkotlin.common.Constants
import com.app.learningkotlin.data.remote.CoinPaprikaApi
import com.app.learningkotlin.data.repository.CoinRepositoryImp
import com.app.learningkotlin.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
 @Provides
 @Singleton
 fun providePaprikaApi():CoinPaprikaApi {
  return Retrofit.Builder()
   .baseUrl(Constants.BASE_URL)
   .addConverterFactory(GsonConverterFactory.create()).build().create(CoinPaprikaApi::class.java)
 }
 @Provides
 @Singleton
 fun providerCoinRepository(api:CoinPaprikaApi):CoinRepository{
  return  CoinRepositoryImp(api)
 }
}