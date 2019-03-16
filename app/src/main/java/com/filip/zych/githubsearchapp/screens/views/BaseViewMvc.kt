package com.filip.zych.githubsearchapp.screens.views

import android.content.Context
import android.view.View

abstract class BaseViewMvc<ListenerType> : BaseObservable<ListenerType>(), ObservableViewMvc<ListenerType> {
    lateinit var mRootView: View

    override fun getRootView(): View {
        return mRootView
    }

    fun setRootView(rootView: View) {
        mRootView = rootView
    }

    fun getContext(): Context {
        return getRootView().context
    }

}