package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.repositorysearch.repositorieslistitem.RepositoriesListItemViewMvc
import com.filip.zych.githubsearchapp.screens.views.ViewMvcFactory

class RepositoriesRvAdapter(private val listener: Listener, private var viewFactory: ViewMvcFactory) : RecyclerView.Adapter<RepositoriesRvAdapter.ViewHolder>(),
    RepositoriesListItemViewMvc.Listener {


    interface Listener {
        fun onRepositoryItemClicked(repositoryItem: ItemSchema)
    }

    override fun onRepositoryItemClicked(repositoryItem: ItemSchema) {
        listener.onRepositoryItemClicked(repositoryItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewMvc = viewFactory.newInstance(RepositoriesListItemViewMvc::class.java, parent)
        viewMvc.registerListener(this)
        return ViewHolder(viewMvc)
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewMvc.bindItem(repositories[position])
    }


    class ViewHolder(val viewMvc: RepositoriesListItemViewMvc) : RecyclerView.ViewHolder(viewMvc.getRootView())


    private var repositories: List<ItemSchema> = emptyList()

    fun bindRepositories(itemSchema: List<ItemSchema>) {
        repositories = ArrayList<ItemSchema>(itemSchema)
        notifyDataSetChanged()
    }

}