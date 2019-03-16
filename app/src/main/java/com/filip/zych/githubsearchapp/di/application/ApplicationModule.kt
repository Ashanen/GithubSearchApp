package com.filip.zych.githubsearchapp.di.application

import com.filip.zych.githubsearchapp.GithubApp
import com.filip.zych.githubsearchapp.githubrepositories.FetchRepositoriesList
import com.filip.zych.githubsearchapp.networking.GithubApi
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: GithubApp){

    @Provides
    fun getRepositoriesList(githubApi: GithubApi) : FetchRepositoriesList{
        return FetchRepositoriesList(githubApi)
    }
}