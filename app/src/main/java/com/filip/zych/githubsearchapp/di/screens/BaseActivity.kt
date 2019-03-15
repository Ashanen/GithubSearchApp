package com.filip.zych.githubsearchapp.di.screens

import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.filip.zych.githubsearchapp.GithubApp
import com.filip.zych.githubsearchapp.di.application.ApplicationComponent
import com.filip.zych.githubsearchapp.di.presentation.PresentationComponent
import com.filip.zych.githubsearchapp.di.presentation.PresentationModule

class BaseActivity : AppCompatActivity() {
    private var isInjectorUsed: Boolean = false

    @UiThread
    fun getPresentationComponent(): PresentationComponent {
        if (isInjectorUsed) {
            throw RuntimeException("there is no need to use injector more than once")
        }
        isInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as GithubApp).getApplicationComponent()
    }
}