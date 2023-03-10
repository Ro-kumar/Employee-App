/*
 * *
 *  * Created by Prady on 22/07/22, 7:49 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 22/07/22, 7:47 AM
 *
 */

package com.example.employee.helpers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class InitFragment<VM : ViewModel, V_BINDING : ViewDataBinding> : Fragment() {

    private var _viewModel: VM? = null
    private var _binding: V_BINDING? = null
    protected val viewModel: VM get() = _viewModel!!
    protected val binding: V_BINDING get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments

        _viewModel = ViewModelProvider(requireActivity())[type[0] as Class<VM>]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutID(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        _viewModel = null
    }

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    abstract fun layoutID(): Int
}