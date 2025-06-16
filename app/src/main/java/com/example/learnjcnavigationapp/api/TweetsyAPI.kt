package com.example.learnjcnavigationapp.api

import com.example.learnjcnavigationapp.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/684bb5e98561e97a502368b9?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/684bb5e98561e97a502368b9?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}