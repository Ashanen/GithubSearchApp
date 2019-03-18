package com.filip.zych.githubsearchapp.di.presentation

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.filip.zych.githubsearchapp.screens.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private var fragmentActivity: FragmentActivity) {


    @Provides
    fun getFragmentManager(): FragmentManager {
        return fragmentActivity.supportFragmentManager
    }

    @Provides
    fun getLayoutInflater(): LayoutInflater {
        return fragmentActivity.layoutInflater
    }

    @Provides
    fun getActivity(): Activity {
        return fragmentActivity
    }

    @Provides
    fun getContext(activity: Activity): Context {
        return activity
    }

    @Provides
    fun getImageLoader(activity: Activity): ImageLoader {
        return ImageLoader(activity)
    }
}