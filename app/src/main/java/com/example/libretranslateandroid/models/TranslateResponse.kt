package com.example.libretranslateandroid.models

data class TranslateResponse(
    val from: From,
    val raw: String,
    val text: String
)

data class Text(
    val autoCorrected: Boolean,
    val didYouMean: Boolean,
    val value: String
)

data class Language(
    val didYouMean: Boolean,
    val iso: String
)

data class From(
    val language: Language,
    val text: Text
)