package com.shenawynkov.test.base

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shenawynkov.test.data.Repo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(val repo: Repo) : ViewModel(), CoroutineScope {
    val _loadingStatus = MutableLiveData<Boolean>(false)
    val loadingStatus: LiveData<Boolean> = _loadingStatus

    var savedFun: () -> Unit = {}
    val title = MutableLiveData<String>()
    val _backPressed = MutableLiveData<Boolean>(false)
    val backpressed: LiveData<Boolean> = _backPressed
    fun backClicked(view: View) {
        _backPressed.value = true
    }



    val job = Job()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    fun retry(view: View?) {
        savedFun()
    }



}