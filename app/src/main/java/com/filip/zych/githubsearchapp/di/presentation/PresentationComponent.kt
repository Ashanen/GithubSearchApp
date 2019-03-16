package com.filip.zych.githubsearchapp.di.presentation

import com.filip.zych.githubsearchapp.screens.repositorysearch.RepositorySearchActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(repositorySearchActivity: RepositorySearchActivity)
}