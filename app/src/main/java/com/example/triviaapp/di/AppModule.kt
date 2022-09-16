package com.example.triviaapp.di

import com.example.triviaapp.network.QuestionApi
import com.example.triviaapp.repository.QuestionRepository
import com.example.triviaapp.util.Constants.BASE_URL
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

    @Singleton
    @Provides
    fun provideQuestionRepository(questionApi: QuestionApi): QuestionRepository =
        QuestionRepository(questionApi)

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)

}