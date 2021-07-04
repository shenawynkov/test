package com.shenawynkov.test.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shenawynkov.test.BaseApp
import com.shenawynkov.test.R
import com.shenawynkov.test.base.BaseFragment
import androidx.navigation.fragment.findNavController

import com.shenawynkov.test.databinding.FragmentHomeBinding
import com.shenawynkov.test.networking.model.LineHolder
import javax.inject.Inject

class HomeFragment :BaseFragment <HomeViewModel, FragmentHomeBinding>() {
    @Inject
    lateinit var factory: HomeViewModelFactory
    override fun provideViewModel(): HomeViewModel {
       return ViewModelProvider(this,factory).get(HomeViewModel::class.java)
    }

    override fun createBinding() = R.layout.fragment_home

    override fun setup() {
        binding.viewmodel=viewModel
        viewModel.done.observe(this, Observer {
            if(it==true&&viewModel.lines.value!!.size>0)
            {
                Log.d("Data:",viewModel.lines.value!!.toString())
              val action =  HomeFragmentDirections.actionHomeFragmentToListFragment(LineHolder(viewModel.lines.value!!))
                findNavController().navigate(action)
            }
        })
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val applicationComponent =
                ((activity?.application) as BaseApp).appComponent
        applicationComponent.inject(this)
    }
}