package com.filip.zych.githubsearchapp.screens.repositorydetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.filip.zych.githubsearchapp.R
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.views.BaseViewMvc
import kotlinx.android.synthetic.main.layout_repository_detail.view.*

class RepositoryDetailsViewMvcImpl(inflater: LayoutInflater, container: ViewGroup?) :
    BaseViewMvc<RepositoryDetailsViewMvc.Listener>(), RepositoryDetailsViewMvc {

    init {
        setRootView(inflater.inflate(R.layout.layout_repository_detail, container, false))
    }


    override fun bindRepositoryDetails(repositoryDetail: ItemSchema) {
        Toast.makeText(getContext(), "entered details activity with success", Toast.LENGTH_SHORT).show()
        getRootView().owner_details_tv.text = repositoryDetail.owner.login
        getRootView().owner_id.text = repositoryDetail.owner.id.toString()
        getRootView().owner_type.text = repositoryDetail.owner.type
        getRootView().full_name.text = repositoryDetail.fullName
        getRootView().description.text = repositoryDetail.description
    }
}