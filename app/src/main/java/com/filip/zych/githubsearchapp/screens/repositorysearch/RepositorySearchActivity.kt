package com.filip.zych.githubsearchapp.screens.repositorysearch

import android.os.Bundle
import android.os.PersistableBundle
import com.filip.zych.githubsearchapp.screens.BaseActivity
import com.filip.zych.githubsearchapp.screens.views.ViewMvcFactory
import javax.inject.Inject

class RepositorySearchActivity : BaseActivity(), RepositoriesListViewMvc.Listener {

    @Inject
    lateinit var viewFactory: ViewMvcFactory


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        getPresentationComponent().inject(this)
        val mvcView = viewFactory.newInstance(RepositoriesListViewMvc::class.java, null)

        setContentView(mvcView.getRootView())
    }


    override fun onRepositoryClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}