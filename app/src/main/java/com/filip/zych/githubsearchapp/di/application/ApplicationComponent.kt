package com.filip.zych.githubsearchapp.di.application

import com.filip.zych.githubsearchapp.di.presentation.PresentationComponent
import com.filip.zych.githubsearchapp.di.presentation.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkingModule::class])
interface ApplicationComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}