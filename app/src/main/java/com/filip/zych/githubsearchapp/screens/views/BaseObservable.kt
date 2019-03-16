package com.filip.zych.githubsearchapp.screens.views

import java.util.*
import java.util.concurrent.ConcurrentHashMap

abstract class BaseObservable<LISTENER_CLASS> {

    private val mListeners = Collections.newSetFromMap(
        ConcurrentHashMap<LISTENER_CLASS, Boolean>(1)
    )

    fun registerListener(listener: LISTENER_CLASS) {
        mListeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_CLASS) {
        mListeners.remove(listener)
    }

    protected fun getListeners(): Set<LISTENER_CLASS> {
        return Collections.unmodifiableSet(mListeners)
    }

}