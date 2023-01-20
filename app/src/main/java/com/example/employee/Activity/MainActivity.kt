package com.example.employee.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.liquid.gold.factories.SharedVMF
import com.example.employee.Fragment.HomeFragment
import com.example.employee.Fragment.ZigZagFragment
import com.example.employee.R


import com.example.employee.utils.ConnectionLiveData
import com.example.employee.viewModels.SharedVM

import com.example.employee.databinding.ActivityMainBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: SharedVMF by instance()
    private lateinit var viewModel: SharedVM

    private lateinit var connectionLiveData: ConnectionLiveData
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[SharedVM::class.java]
        loadFragment(HomeFragment())
//        binding.bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.zigzip -> {
                    loadFragment(ZigZagFragment())
                    true
                }

                else -> {
                   true
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }



}