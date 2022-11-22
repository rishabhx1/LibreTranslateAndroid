package com.example.libretranslateandroid

import com.example.libretranslateandroid.models.TranslateResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {
    @GET("translate")
    fun translate(
        @Query("source_language") sourceLanguage: String,
        @Query("target_language") targetLanguage: String,
        @Query("text") text: String
    ): Call<TranslateResponse>
}