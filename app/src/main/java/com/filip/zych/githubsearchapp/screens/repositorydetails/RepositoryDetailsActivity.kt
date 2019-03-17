package com.filip.zych.githubsearchapp.screens.repositorydetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.BaseActivity
import com.filip.zych.githubsearchapp.screens.views.ViewMvcFactory
import javax.inject.Inject

const val REPOSITORY_DETAILS_ITEM_EXTRA = "REPOSITORY_DETAILS_ITEM_EXTRA"

class RepositoryDetailsActivity: BaseActivity(), RepositoryDetailsViewMvc.Listener {

    companion object {
        fun startDetailsActivity(context: Context, repositoryItem : ItemSchema){
        val intent = Intent(context, RepositoryDetailsActivity::class.java)
            intent.putExtra(REPOSITORY_DETAILS_ITEM_EXTRA, repositoryItem)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory
    lateinit var viewMvc : RepositoryDetailsViewMvc
    lateinit var repositoryDetailSchema: ItemSchema


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)
        viewMvc = viewMvcFactory.newInstance(RepositoryDetailsViewMvc::class.java, null)
        setContentView(viewMvc.getRootView())

        repositoryDetailSchema = intent.getSerializableExtra(REPOSITORY_DETAILS_ITEM_EXTRA) as ItemSchema

        viewMvc.bindRepositoryDetails(repositoryDetailSchema)
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
    }

}