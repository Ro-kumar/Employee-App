package com.example.employee.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.liquid.gold.factories.SharedVMF
import com.example.employee.Model.EmployeelistRespons
import com.example.employee.Model.EmptyRequest

import com.example.employee.viewModels.SharedVM
import com.example.employee.R
import com.example.employee.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MapsActivity : AppCompatActivity(), KodeinAware, OnMapReadyCallback {


    private lateinit var binding: ActivityMapsBinding
    var lat = ""
    var long = ""

    override val kodein: Kodein by kodein()
    private val factory: SharedVMF by instance()
    private lateinit var viewModel: SharedVM
    private var arrayList: ArrayList<LatLng>? = null
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, factory)[SharedVM::class.java]

        arrayList = ArrayList<LatLng>()
        getEmployee(EmptyRequest())
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



lat=intent.getStringExtra("lat").toString()
long=intent.getStringExtra("long").toString()

        arrayList?.add(
            LatLng(
                lat.toDouble(),
                long.toDouble()
            )
        )

    }


    private fun getEmployee(req: EmptyRequest) {
        viewModel.employeeList = MutableLiveData()
        viewModel.employeeList.observe(this, Observer {
            val response = Gson().fromJson(it, EmployeelistRespons::class.java)

            for (i in 0 until response.data.count()) {
//                arrayList?.add(
//                    LatLng(
//                       response.data[i].lat.toDouble(),
//                        response.data[i].lng.toDouble()
//                    )
//                )


            }


        })

        viewModel.employeeList(req)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //  arrayList.size
        for (i in arrayList!!.indices) {
//            Toast.makeText(this, "" + arrayList.toString(), Toast.LENGTH_SHORT).show()
            mMap!!.addMarker(MarkerOptions().position(arrayList!![i]).title("Marker"))
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList!![i]))
        }

    }
}