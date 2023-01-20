package com.example.employee.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employee.databinding.ActivitySelectedEmployeeBinding

import com.squareup.picasso.Picasso

class SelectedEmployeeActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectedEmployeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.name.text = intent.getStringExtra("name")
        binding.email.text = intent.getStringExtra("email")
        binding.mobile.text = intent.getStringExtra("mobile")
        binding.address.text = intent.getStringExtra("address")
        Picasso.get().load(intent.getStringExtra("image")).into(binding.image)

        binding.back.setOnClickListener { finish() }

    }
}