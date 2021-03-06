package com.filip.zych.githubsearchapp.githubrepositories

import com.filip.zych.githubsearchapp.networking.GithubApi
import com.filip.zych.githubsearchapp.networking.RepositoriesListSchema
import com.filip.zych.githubsearchapp.screens.views.BaseObservable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FetchRepositoriesList(val githubApi: GithubApi) : BaseObservable<FetchRepositoriesList.Listener>() {

    interface Listener {
        fun onFetchRepositoriesSucceeded(repositoriesList: RepositoriesListSchema)
        fun onFetchRepositoriesFailed()
    }

    lateinit var cal1: Call<RepositoriesListSchema>

    fun fetchRepositoriesAndNotify(query: String) {
        if (query.isEmpty()) {
            notifySucceeded(RepositoriesListSchema(false, emptyList(), 0))
            return
        }
        cal1 = githubApi.repositoriesList(query)

        cal1.enqueue(object : Callback<RepositoriesListSchema> {
            override fun onFailure(call: Call<RepositoriesListSchema>, t: Throwable) {
                notifyFailed()
            }

            override fun onResponse(call: Call<RepositoriesListSchema>, response: Response<RepositoriesListSchema>) {
                if (response.isSuccessful) {
                    notifySucceeded(response.body()!!)
                } else {
                    notifyFailed()
                }
            }
        })
    }

    private fun notifySucceeded(repositories: RepositoriesListSchema) {
        for (listener in getListeners()) {
            listener.onFetchRepositoriesSucceeded(repositories)
        }
    }

    private fun notifyFailed() {
        for (listener in getListeners()) {
            listener.onFetchRepositoriesFailed()
        }
    }
}