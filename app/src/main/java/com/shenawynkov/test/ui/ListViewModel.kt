package com.shenawynkov.test.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.shenawynkov.test.base.BaseViewModel
import com.shenawynkov.test.data.Repo
import com.shenawynkov.test.networking.model.LineResponse
import kotlinx.coroutines.launch

class ListViewModel(repo: Repo) :BaseViewModel(repo){
   val  lines= MutableLiveData<ArrayList<LineResponse>>(ArrayList())



}