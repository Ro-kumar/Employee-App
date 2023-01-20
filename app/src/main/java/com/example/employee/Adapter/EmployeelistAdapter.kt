package com.example.employee.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.Model.Data
import com.example.employee.databinding.EmployeeItemBinding

import com.squareup.picasso.Picasso


class EmployeelistAdapter(var context: Context, var list: List<Data>,private val listener: OnCategoriesItemClickListener) :
    RecyclerView.Adapter<EmployeelistAdapter.ViewHolder>() {



    private val selectedPosition = 0
    private val selectCheck: ArrayList<Int> = ArrayList()




    interface OnCategoriesItemClickListener {
        @SuppressLint("NotConstructor")
        fun OnCategoriesItemClickListener(

            list: List<Data>,
            position: Int

        )
    }

    private fun OnEmployeeItemClickListener(list: List<Data>,position: Int
    ) {
        listener.OnCategoriesItemClickListener(list,position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text = list[position].name
        holder.binding.email.text = list[position].email
        holder.binding.mobile.text = list[position].mobile_no
        holder.binding.address.text = list[position].address
        Picasso.get().load(list[position].image).into(holder.binding.image)


//initilize selectCheck
        //initilize selectCheck
        for (i in list.indices) {
            selectCheck.add(0)
        }



        if (selectCheck.get(position) === 1) {
            holder.binding.checkBox.setChecked(true)
        } else {
            holder.binding.checkBox.setChecked(false)
        }
        holder.binding.checkBox.setOnClickListener {
            for (k in 0 until selectCheck.size) {
                if (k == position) {
                    selectCheck.set(k, 1)
                } else {
                    selectCheck.set(k, 0)
                }
            }
            notifyDataSetChanged()
        }


        holder.binding.checkBox.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                OnEmployeeItemClickListener(list,position)
            }
        })

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(var binding: EmployeeItemBinding) : RecyclerView.ViewHolder(binding.root)
}