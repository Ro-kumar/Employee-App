/*
 * *
 *  * Created by Prady on 22/07/22, 7:49 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 22/07/22, 7:47 AM
 *
 */

package com.example.employee.helpers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.MaterialToolbar
import java.lang.reflect.ParameterizedType

abstract class InitActivity<VM : ViewModel, V_BINDING : ViewDataBinding> : AppCompatActivity() {

    private var _viewModel: VM? = null
    private var _binding: V_BINDING? = null
    protected val viewModel: VM get() = _viewModel!!
    protected val binding: V_BINDING get() = _binding!!
    private var _toolbar: MaterialToolbar? = null
    val toolbar: MaterialToolbar? get() = _toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments

        _viewModel = ViewModelProvider(this)[type[0] as Class<VM>]
        _binding = DataBindingUtil.setContentView(this, layoutID())
        binding.lifecycleOwner = this
//        _toolbar = binding.root.findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        _viewModel = null
    }

    abstract fun layoutID(): Int
}