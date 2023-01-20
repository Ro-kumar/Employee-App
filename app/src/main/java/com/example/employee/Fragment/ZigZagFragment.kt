package com.example.employee.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.app.liquid.gold.factories.SharedVMF
import com.example.employee.Adapter.ZigZagAdapter

import com.example.employee.viewModels.SharedVM
import com.example.employee.databinding.FragmentZigZagBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext


class ZigZagFragment : Fragment(),KodeinAware {
    lateinit var binding: FragmentZigZagBinding
    override val kodeinContext = kcontext<Fragment>(this)
    override val kodein: Kodein by kodein()
    private val factory: SharedVMF by instance()
    private lateinit var viewModel: SharedVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentZigZagBinding.inflate(layoutInflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity(), factory)[SharedVM::class.java]



        var adpter1 = context?.let { ZigZagAdapter(it) }
        val gridLayoutManager = context?.let { GridLayoutManager(it, 2) }
        binding.zigzabRv.layoutManager = gridLayoutManager
        binding.zigzabRv.setHasFixedSize(true)
        binding.zigzabRv.itemAnimator = DefaultItemAnimator()
        binding.zigzabRv.adapter = adpter1




    }


}