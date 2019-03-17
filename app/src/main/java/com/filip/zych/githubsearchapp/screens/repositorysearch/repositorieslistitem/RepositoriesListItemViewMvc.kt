package com.filip.zych.githubsearchapp.screens.repositorysearch.repositorieslistitem

import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.ObservableViewMvc

interface RepositoriesListItemViewMvc: ObservableViewMvc<RepositoriesListItemViewMvc.Listener>{

    interface Listener {
    fun onRepositoryItemClicked(repositoryItem : ItemSchema)
    }

    fun bindItem(repositoryItem : ItemSchema)
}