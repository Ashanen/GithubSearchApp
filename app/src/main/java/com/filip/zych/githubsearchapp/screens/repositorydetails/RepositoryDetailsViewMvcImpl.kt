package com.filip.zych.githubsearchapp.screens.repositorydetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.filip.zych.githubsearchapp.R
import com.filip.zych.githubsearchapp.networking.ItemSchema
import com.filip.zych.githubsearchapp.screens.ImageLoader
import com.filip.zych.githubsearchapp.screens.views.BaseViewMvc
import kotlinx.android.synthetic.main.layout_repository_detail.view.*

class RepositoryDetailsViewMvcImpl(inflater: LayoutInflater, container: ViewGroup?, private val imageLoader: ImageLoader) :
    BaseViewMvc<RepositoryDetailsViewMvc.Listener>(), RepositoryDetailsViewMvc {

    init {
        setRootView(inflater.inflate(R.layout.layout_repository_detail, container, false))
    }


    override fun bindRepositoryDetails(repositoryDetail: ItemSchema) {
        getRootView().owner_login.text = getContext().getString(R.string.owner_login, repositoryDetail.owner.login)
        getRootView().owner_id.text = getContext().getString(R.string.owner_id, repositoryDetail.owner.id.toString())
        getRootView().owner_type.text = getContext().getString(R.string.type, repositoryDetail.owner.type)
        getRootView().full_name.text = getContext().getString(R.string.full_repository_name, repositoryDetail.fullName)
        getRootView().description.text = getContext().getString(R.string.description, repositoryDetail.description)

        imageLoader.loadImage(repositoryDetail.owner.avatarUrl, getRootView().owner_avatar)
    }
}