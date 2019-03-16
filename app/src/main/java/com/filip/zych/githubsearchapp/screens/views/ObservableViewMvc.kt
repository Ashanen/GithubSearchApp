package com.filip.zych.githubsearchapp.screens.views


interface ObservableViewMvc<ListenerType> : ViewMvc {
    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}