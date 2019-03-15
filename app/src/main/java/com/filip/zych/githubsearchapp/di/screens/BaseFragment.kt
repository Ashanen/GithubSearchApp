package com.filip.zych.githubsearchapp.di.screens

import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.filip.zych.githubsearchapp.GithubApp
import com.filip.zych.githubsearchapp.di.application.ApplicationComponent
import com.filip.zych.githubsearchapp.di.presentation.PresentationComponent
import com.filip.zych.githubsearchapp.di.presentation.PresentationModule

class BaseFragment : Fragment() {
    private var isInjectorUsed: Boolean = false

    @UiThread
    fun getPresentationComponent(): PresentationComponent {
        if (isInjectorUsed) {
            throw RuntimeException("there is no need to use injector more than once")
        }
        isInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(activity!!))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (activity!!.application as GithubApp).getApplicationComponent()
    }
}