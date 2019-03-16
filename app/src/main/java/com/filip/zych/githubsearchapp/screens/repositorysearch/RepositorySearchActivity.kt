package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.os.Bundle
import android.widget.Toast
import com.filip.zych.githubsearchapp.githubrepositories.FetchRepositoriesList
import com.filip.zych.githubsearchapp.networking.RepositoriesListSchema
import com.filip.zych.githubsearchapp.screens.BaseActivity
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

        fetchRepositoriesList.fetchRepositoriesAndNotify()
    }


    override fun onStop() {
        super.onStop()
        mvcView.unregisterListener(this)
        fetchRepositoriesList.unregisterListener(this)
    }


    override fun onRepositoryClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFetchRepositoriesSucceeded(repositoriesList: RepositoriesListSchema) {
        Toast.makeText(this, "fetched with success", Toast.LENGTH_SHORT).show()
    }

    override fun onFetchRepositoriesFailed() {
        Toast.makeText(this, "fetched with failure", Toast.LENGTH_SHORT).show()
    }


}