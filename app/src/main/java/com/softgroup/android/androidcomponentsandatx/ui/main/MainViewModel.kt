package com.softgroup.android.androidcomponentsandatx.ui.main

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softgroup.android.androidcomponentsandatx.BR
import com.softgroup.android.androidcomponentsandatx.model.User
import com.softgroup.android.androidcomponentsandatx.repository.RetrofitService
import com.softgroup.android.androidcomponentsandatx.utils.SchedulerRxTransformer

class MainViewModel : ViewModel(), Observable {


    val users: MutableLiveData<List<User>> = MutableLiveData()

    val count: MutableLiveData<Int> = MutableLiveData()

    val countc = ObservableField<Int>(0)

    init {
        count.value = 0
    }

    public fun loadUsers() {
        RetrofitService.instance.gorestApi.getUsers()
            .compose(SchedulerRxTransformer.networkTransformer())
            .subscribe {

                if (it.code() == 200 || it.code() == 201) {
                    users.value = it.body()?.result
                    count.value = it.code()
                    countc.set(it.code())

                    Log.d("fasdfasdf", it.code().toString())
                }

            }
    }

    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    override fun addOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback
    ) {
        callbacks.remove(callback)
    }

    /**
     * Notifies observers that all properties of this instance have changed.
     */
    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    /**
     * Notifies observers that a specific property has changed. The getter for the
     * property that changes should be marked with the @Bindable annotation to
     * generate a field in the BR class to be used as the fieldId parameter.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }

}