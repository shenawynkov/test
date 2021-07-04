package com.shenawynkov.test.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shenawynkov.test.BaseApp
import com.shenawynkov.test.R
import com.shenawynkov.test.base.BaseFragment
import com.shenawynkov.test.databinding.FragmentListBinding
import com.shenawynkov.test.networking.model.LineResponse
import javax.inject.Inject


class ListFragment : BaseFragment<ListViewModel,FragmentListBinding>() {

    private  val args:ListFragmentArgs by navArgs()
    @Inject
    lateinit var factory: ListViewModelFactory
    override fun provideViewModel(): ListViewModel {
        return  ViewModelProvider(this,factory).get(ListViewModel::class.java)

    }

    override fun createBinding(): Int =R.layout.fragment_list
    override fun setup() {
      viewModel.lines.value=  args.line.lines
        Log.d("Data2:",viewModel.lines.value!!.toString())

        binding.viewmodel=viewModel
        binding.lifecycleOwner=this

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val applicationComponent =
                ((activity?.application) as BaseApp).appComponent
        applicationComponent.inject(this)
    }


}