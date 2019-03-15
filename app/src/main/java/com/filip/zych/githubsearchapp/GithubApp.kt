package com.filip.zych.githubsearchapp

import android.app.Application
import com.filip.zych.githubsearchapp.di.application.ApplicationModule
import com.filip.zych.githubsearchapp.di.application.ApplicationComponent
import com.filip.zych.githubsearchapp.di.application.DaggerApplicationComponent

class GithubApp : Application() {
    private lateinit var appComponent : ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        initApplication()
    }

    private fun initApplication(){
        appComponent =
            DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return appComponent
    }

}