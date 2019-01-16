package com.softgroup.android.androidcomponentsandatx.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.softgroup.android.androidcomponentsandatx.R
import com.softgroup.android.androidcomponentsandatx.databinding.ActivityMainBinding
import com.softgroup.android.androidcomponentsandatx.repository.RetrofitService

class MainActivity : AppCompatActivity(), LifecycleOwner{

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var mLifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mLifecycleRegistry = LifecycleRegistry(this)
        mLifecycleRegistry.markState(Lifecycle.State.CREATED)
        binding.viewmodel = mainViewModel
        binding.setLifecycleOwner(this)
        mainViewModel.loadUsers()

        mainViewModel.count.observeForever {
            Toast.makeText(this, "sdfsdfsf $it", Toast.LENGTH_SHORT).show()
        }
//        mainViewModel.users.value.size

    }

    override fun onStart() {
        super.onStart()
        mLifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }
}
