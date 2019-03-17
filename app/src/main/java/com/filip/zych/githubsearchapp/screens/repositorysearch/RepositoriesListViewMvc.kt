package com.filip.zych.githubsearchapp.screens.repositorysearch

import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.ObservableViewMvc

interface RepositoriesListViewMvc : ObservableViewMvc<RepositoriesListViewMvc.Listener> {
    interface Listener {
        fun onRepositoryClicked(repository : ItemSchema)
    }

    fun bindItems(repositories: List<ItemSchema>)
}