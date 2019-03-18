package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.os.Bundle
import android.widget.Toast
import com.filip.zych.githubsearchapp.githubrepositories.FetchRepositoriesList
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.networking.RepositoriesListSchema
import com.filip.zych.githubsearchapp.screens.BaseActivity
import com.filip.zych.githubsearchapp.screens.repositorydetails.RepositoryDetailsActivity.Companion.startDetailsActivity
import com.filip.zych.githubsearchapp.screens.views.ViewMvcFactory
import javax.inject.Inject

class RepositorySearchActivity : BaseActivity(), RepositoriesListViewMvc.Listener, FetchRepositoriesList.Listener {

    @Inject
    lateinit var viewFactory: ViewMvcFactory
    @Inject
    lateinit var fetchRepositoriesList: FetchRepositoriesList

    lateinit var mvcView: RepositoriesListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)
        mvcView = viewFactory.newInstance(RepositoriesListViewMvc::class.java, null)

        setContentView(mvcView.getRootView())
    }

    override fun onStart() {
        super.onStart()
        mvcView.registerListener(this)
        fetchRepositoriesList.registerListener(this)
    }


    override fun onStop() {
        super.onStop()
        mvcView.unregisterListener(this)
        fetchRepositoriesList.unregisterListener(this)
    }


    override fun onRepositoryClicked(repository: ItemSchema) {
        startDetailsActivity(this, repository)
    }

    override fun onFetchRepositoriesSucceeded(repositoriesList: RepositoriesListSchema) {
        mvcView.bindItems(repositoriesList.itemSchemas)
        mvcView.hideProgressBar()
    }

    override fun onFetchRepositoriesFailed() {
        mvcView.hideProgressBar()
    }

    override fun onSearchTyped(query: String) {
        mvcView.showProgressBar()
        fetchRepositoriesList.fetchRepositoriesAndNotify(query)
    }
}