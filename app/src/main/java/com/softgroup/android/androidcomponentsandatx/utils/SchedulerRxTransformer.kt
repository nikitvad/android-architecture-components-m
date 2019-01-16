package com.softgroup.android.androidcomponentsandatx.utils

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object SchedulerRxTransformer{
    @JvmStatic
    fun <T> networkTransformer():ObservableTransformer<T, T>{
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }

    }
}