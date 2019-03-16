package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.view.LayoutInflater
import android.view.ViewGroup
import com.filip.zych.githubsearchapp.R
import com.filip.zych.githubsearchapp.screens.views.BaseViewMvc

class ResositoriesListViewMvcImpl(inflater: LayoutInflater, container: ViewGroup) :
    BaseViewMvc<RepositoriesListViewMvc.Listener>(), RepositoriesListViewMvc {

    init {
        setRootView(inflater.inflate(R.layout.layout_repositories_list, container, false))
        // TODO init recycler
    }
}