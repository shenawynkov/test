package com.shenawynkov.test.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.shenawynkov.test.base.BaseViewModel
import com.shenawynkov.test.data.Repo
import com.shenawynkov.test.networking.model.LineResponse
import kotlinx.coroutines.launch

class HomeViewModel(repo: Repo) :BaseViewModel(repo){
    val text =MutableLiveData<String>()
   val  lines= MutableLiveData<ArrayList<LineResponse>>(ArrayList())
    val done=MutableLiveData<Boolean>(false)


    fun analyse (view:View)
    {
       val prelines= text.value?.lines()
        if(prelines!=null)

        launch {
            for(line in prelines)
            {
                repo.getLines(lines,line)

            }
            done.value=true
        }
    }
}