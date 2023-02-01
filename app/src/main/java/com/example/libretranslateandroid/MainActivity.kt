package com.example.libretranslateandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.libretranslateandroid.ui.theme.LibreTranslateAndroidTheme


class MainActivity : ComponentActivity() {

    val presenter: MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibreTranslateAndroidTheme {
                HomeScreen(
                    presenter.translatedText,
                    onClick = { sourceLanguage, targetLanguage, text ->
                        presenter.doTranslate(
                            sourceLanguage,
                            targetLanguage,
                            text
                        )
                    }
                )
            }
        }
    }
}