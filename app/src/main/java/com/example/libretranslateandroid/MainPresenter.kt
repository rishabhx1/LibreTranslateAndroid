package com.example.libretranslateandroid

import android.util.Log
import com.example.libretranslateandroid.models.TranslateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenter {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.6:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: TranslateService = retrofit.create(TranslateService::class.java)

    fun doTranslate() {
        service.translate(
            sourceLanguage = "en",
            targetLanguage = "hi",
            text = "Hello"
        ).enqueue(object : Callback<TranslateResponse> {
            override fun onResponse(
                call: Call<TranslateResponse>,
                response: Response<TranslateResponse>
            ) {
                Log.i("Translate Response", response.body().toString());
            }

            override fun onFailure(call: Call<TranslateResponse>, t: Throwable) {
                Log.e("Translate Response", "Error", t);
            }
        })
    }
}