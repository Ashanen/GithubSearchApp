package com.filip.zych.githubsearchapp.screens.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.filip.zych.githubsearchapp.screens.repositorysearch.RepositoriesListViewMvc
import com.filip.zych.githubsearchapp.screens.repositorysearch.ResositoriesListViewMvcImpl
import javax.inject.Inject

class ViewMvcFactory
@Inject constructor(private val layoutInflater : LayoutInflater){

    fun <T : ViewMvc> newInstance(mvcViewClass: Class<T>, @Nullable container: ViewGroup?): T {

        val viewMvc: ViewMvc

        when (mvcViewClass) {
            RepositoriesListViewMvc::class.java -> viewMvc = ResositoriesListViewMvcImpl(layoutInflater, container!!)
            else -> throw IllegalArgumentException("This mvc view is not supported, please add it $mvcViewClass")
        }
        return viewMvc as T
    }

}