package com.example.libretranslateandroid

import android.util.Log
import com.example.libretranslateandroid.models.TranslateResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenter {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.5:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: TranslateService = retrofit.create(TranslateService::class.java)

    private var _translatedText = MutableStateFlow<String>("")
    val translatedText: StateFlow<String> = _translatedText.asStateFlow()


    fun doTranslate(
        sourceLanguage: String,
        targetLanguage: String,
        text: String
    ) {
        service.translate(
            sourceLanguage,
            targetLanguage,
            text
        ).enqueue(object : Callback<TranslateResponse> {
            override fun onResponse(
                call: Call<TranslateResponse>,
                response: Response<TranslateResponse>
            ) {
                _translatedText.value = response.body()?.text ?: ""
                Log.i("Translate Response", response.body().toString());
            }

            override fun onFailure(call: Call<TranslateResponse>, t: Throwable) {
                Log.e("Translate Response", "Error", t);
            }
        })
    }
}