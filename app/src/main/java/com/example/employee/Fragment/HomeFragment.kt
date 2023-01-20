package com.example.employee.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.liquid.gold.factories.SharedVMF
import com.example.employee.Activity.MapsActivity
import com.example.employee.Activity.SelectedEmployeeActivity
import com.example.employee.Adapter.EmployeelistAdapter
import com.example.employee.Model.Data
import com.example.employee.Model.EmployeelistRespons
import com.example.employee.Model.EmptyRequest
import com.example.employee.viewModels.SharedVM
import com.example.employee.databinding.FragmentHomeBinding
import com.google.gson.Gson
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class HomeFragment : Fragment(), KodeinAware, EmployeelistAdapter.OnCategoriesItemClickListener {
    lateinit var binding: FragmentHomeBinding
    override val kodeinContext = kcontext<Fragment>(this)
    override val kodein: Kodein by kodein()
    private val factory: SharedVMF by instance()
    private lateinit var viewModel: SharedVM


    val arrayList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity(), factory)[SharedVM::class.java]


        binding.next.setOnClickListener {
            if (arrayList.isEmpty()) {
                Toast.makeText(context, "Please Select The Employee", Toast.LENGTH_SHORT).show()
            }else{
                var intent= Intent(context,SelectedEmployeeActivity::class.java)
                intent.putExtra("name", arrayList[0].toString())
                intent.putExtra("email", arrayList[1].toString())
                intent.putExtra("mobile", arrayList[2].toString())
                intent.putExtra("address", arrayList[3].toString())
                intent.putExtra("image", arrayList[4].toString())
                startActivity(intent)
            }
        }

        binding.mapview.setOnClickListener {
            if (arrayList.isEmpty()) {
                Toast.makeText(context, "Please Select The Employee", Toast.LENGTH_SHORT).show()
            }else{
                var intent= Intent(context,MapsActivity::class.java)
                intent.putExtra("lat", arrayList[5].toString())
                intent.putExtra("long", arrayList[6].toString())


                startActivity(intent)
            }


        }

        getEmployee(EmptyRequest())

    }

    private fun getEmployee(req: EmptyRequest) {
        viewModel.employeeList = MutableLiveData()
        activity?.let {
            viewModel.employeeList.observe(it, Observer {
                val response = Gson().fromJson(it, EmployeelistRespons::class.java)
                binding.employeeListRv.apply {
                    val gridManager = LinearLayoutManager(context)
                    layoutManager = gridManager
                    adapter = EmployeelistAdapter(context, response.data, this@HomeFragment)
                }
            })
        }
        viewModel.employeeList(req)
    }

    override fun OnCategoriesItemClickListener(list: List<Data>, position: Int) {
        if (arrayList.isEmpty()) {
            arrayList.add(list[position].name)
            arrayList.add(list[position].email)
            arrayList.add(list[position].mobile_no)
            arrayList.add(list[position].address)
            arrayList.add(list[position].image)
            arrayList.add(list[position].lat)
            arrayList.add(list[position].lng)
            arrayList.add(list.toString())

        } else {
            arrayList.clear()
            arrayList.add(list[position].name)
            arrayList.add(list[position].email)
            arrayList.add(list[position].mobile_no)
            arrayList.add(list[position].address)
            arrayList.add(list[position].image)
            arrayList.add(list[position].lat)
            arrayList.add(list[position].lng)

            arrayList.add(list.toString())
        }


    }


}