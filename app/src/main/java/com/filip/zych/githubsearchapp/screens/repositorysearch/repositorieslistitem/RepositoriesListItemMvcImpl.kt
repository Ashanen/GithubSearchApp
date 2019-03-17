package com.filip.zych.githubsearchapp.screens.repositorysearch.repositorieslistitem

import android.view.LayoutInflater
import android.view.ViewGroup
import com.filip.zych.githubsearchapp.R
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.BaseViewMvc
import kotlinx.android.synthetic.main.layout_repository_list_item.view.*

class RepositoriesListItemMvcImpl(inflater: LayoutInflater, container: ViewGroup?) :
    BaseViewMvc<RepositoriesListItemViewMvc.Listener>(), RepositoriesListItemViewMvc {

    lateinit var repositoryItem: ItemSchema

    init {
        setRootView(inflater.inflate(R.layout.layout_repository_list_item, container, false))

        getRootView().setOnClickListener {
            for (listener in getListeners()) {
                listener.onRepositoryItemClicked(repositoryItem)
            }
        }
    }


    override fun bindItem(repositoryItem: ItemSchema) {
        this.repositoryItem = repositoryItem
        getRootView().txt_title.text = repositoryItem.owner.toString()
    }
}