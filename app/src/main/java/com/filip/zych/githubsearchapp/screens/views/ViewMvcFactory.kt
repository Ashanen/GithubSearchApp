package com.filip.zych.githubsearchapp.screens.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.filip.zych.githubsearchapp.screens.repositorydetails.RepositoryDetailsViewMvc
import com.filip.zych.githubsearchapp.screens.repositorydetails.RepositoryDetailsViewMvcImpl
import com.filip.zych.githubsearchapp.screens.repositorysearch.RepositoriesListViewMvc
import com.filip.zych.githubsearchapp.screens.repositorysearch.ResositoriesListViewMvcImpl
import com.filip.zych.githubsearchapp.screens.repositorysearch.repositorieslistitem.RepositoriesListItemMvcImpl
import com.filip.zych.githubsearchapp.screens.repositorysearch.repositorieslistitem.RepositoriesListItemViewMvc
import javax.inject.Inject

class ViewMvcFactory
@Inject constructor(val layoutInflater : LayoutInflater){

    fun <T : ViewMvc> newInstance(mvcViewClass: Class<T>, @Nullable container: ViewGroup?): T {

        val viewMvc: ViewMvc

        when (mvcViewClass) {
            RepositoriesListViewMvc::class.java -> viewMvc = ResositoriesListViewMvcImpl(layoutInflater, container, this)
            RepositoriesListItemViewMvc::class.java -> viewMvc = RepositoriesListItemMvcImpl(layoutInflater, container)
            RepositoryDetailsViewMvc::class.java -> viewMvc = RepositoryDetailsViewMvcImpl(layoutInflater, container)
            else -> throw IllegalArgumentException("This mvc view is not supported, please add it $mvcViewClass")
        }
        return viewMvc as T
    }

}