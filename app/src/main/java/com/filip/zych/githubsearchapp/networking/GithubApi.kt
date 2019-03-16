package com.filip.zych.githubsearchapp.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/repositories")
    fun repositoriesList(@Query ("q") query: String) : Call<RepositoriesListSchema>

}