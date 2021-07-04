package com.shenawynkov.test.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shenawynkov.test.data.Repo

import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(

    private val repo: Repo

) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(

            repo
        ) as T
    }


}