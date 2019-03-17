package com.filip.zych.githubsearchapp.screens.repositorydetails

import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.ObservableViewMvc

interface RepositoryDetailsViewMvc : ObservableViewMvc<RepositoryDetailsViewMvc.Listener> {

    interface Listener {
        // no implementation
    }

    fun bindRepositoryDetails(repositoryDetail: ItemSchema)
}