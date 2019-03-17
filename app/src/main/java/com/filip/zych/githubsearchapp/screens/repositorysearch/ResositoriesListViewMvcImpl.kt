package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.filip.zych.githubsearchapp.R
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.BaseViewMvc
import com.filip.zych.githubsearchapp.screens.views.ViewMvcFactory

class ResositoriesListViewMvcImpl(inflater: LayoutInflater, container: ViewGroup?, viewMvcFactory: ViewMvcFactory) :
    BaseViewMvc<RepositoriesListViewMvc.Listener>(), RepositoriesListViewMvc, RepositoriesRvAdapter.Listener {

    private var adapter: RepositoriesRvAdapter
    private var recyclerView: RecyclerView

    init {
        setRootView(inflater.inflate(R.layout.layout_repositories_list, container, false))
        recyclerView = getRootView().findViewById(R.id.recycler_view_repositories_list)
        recyclerView.layoutManager = LinearLayoutManager(getContext())
        adapter = RepositoriesRvAdapter(this, viewMvcFactory)
        recyclerView.adapter = adapter
    }

    override fun bindItems(repositories: List<ItemSchema>) {
        adapter.bindRepositories(repositories)
    }

    override fun onRepositoryItemClicked(repositoryItem: ItemSchema) {
        for (listener in getListeners()) {
            listener.onRepositoryClicked(repositoryItem)
        }
    }

}