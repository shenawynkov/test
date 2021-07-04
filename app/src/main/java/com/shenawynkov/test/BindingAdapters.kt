package com.shenawynkov.test

import ae.digitalwise.ecommerce.base.GenericAdapter
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


object BindingAdapters {

   @JvmStatic // add this line !!
    @BindingAdapter("app:recycler","app:customLayout")
    fun setGenericRecycler(recycler: RecyclerView, resource: List<Any>?, layout:Int) {
       if (resource==null)
           return
        recycler.apply { layoutManager= LinearLayoutManager(recycler.context)
        adapter= GenericAdapter(resource as ArrayList<*>,layout)
        }

    }



}