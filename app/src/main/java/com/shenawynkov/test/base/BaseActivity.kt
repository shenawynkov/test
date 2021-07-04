package com.shenawynkov.test.base

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*
import kotlin.coroutines.CoroutineContext


abstract class BaseActivity<T : BaseViewModel, G : ViewDataBinding> : AppCompatActivity(),

    CoroutineScope {






    private lateinit var job: Job
    lateinit var viewModel: T
    lateinit var binding: G
    lateinit var statusObserver: Observer<Int>


    abstract fun createBinding(): Int
    open fun inject() {}
    private fun bind(layout: Int) {
        binding = DataBindingUtil.setContentView<G>(
            this,
            layout
        )

        //    binding.root.setLayoutDirection(TextUtils.getLayoutDirectionFromLocale(locale))

        binding.lifecycleOwner = this

    }

    abstract fun provideViewModel(): T

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)

        inject()
        job = Job()
        bind(createBinding())

        viewModel = provideViewModel()




    }
    override fun onResume() {
        super.onResume()


    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()

    }






    open fun backPressed() {
        finish()

    }



}
