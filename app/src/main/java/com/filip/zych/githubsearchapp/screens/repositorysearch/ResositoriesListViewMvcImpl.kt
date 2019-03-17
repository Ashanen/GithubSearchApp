package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.filip.zych.githubsearchapp.R
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.BaseViewMvc
import com.filip.zych.githubsearchapp.screens.views.ViewMvcFactory
import kotlinx.android.synthetic.main.layout_repositories_list.view.*
import kotlinx.coroutines.*

class ResositoriesListViewMvcImpl(inflater: LayoutInflater, container: ViewGroup?, viewMvcFactory: ViewMvcFactory) :
    BaseViewMvc<RepositoriesListViewMvc.Listener>(), RepositoriesListViewMvc, RepositoriesRvAdapter.Listener {

    private var adapter: RepositoriesRvAdapter
    private var recyclerView: RecyclerView
    private var searchBox: EditText
    private var textChangedJob: Job? = null

    init {
        setRootView(inflater.inflate(R.layout.layout_repositories_list, container, false))
        recyclerView = getRootView().recycler_view_repositories_list
        searchBox = getRootView().search_box
        recyclerView.layoutManager = LinearLayoutManager(getContext())
        adapter = RepositoriesRvAdapter(this, viewMvcFactory)
        recyclerView.adapter = adapter

        setOnTextChangeListener()
    }

    override fun bindItems(repositories: List<ItemSchema>) {
        adapter.bindRepositories(repositories)
    }

    override fun onRepositoryItemClicked(repositoryItem: ItemSchema) {
        for (listener in getListeners()) {
            listener.onRepositoryClicked(repositoryItem)
        }
    }

    private fun setOnTextChangeListener() {
        var searchFor = searchBox.text.toString()
        searchBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                val searchText = editable.toString().trim()
                if (searchText != searchFor) {
                    searchFor = searchText
                    textChangedJob?.cancel()
                    textChangedJob = GlobalScope.launch(Dispatchers.Main) {
                        delay(1000)
                        for (listener in getListeners()) {
                            listener.onSearchTyped(searchText)
                        }
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }


}