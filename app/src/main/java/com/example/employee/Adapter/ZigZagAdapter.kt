package com.example.employee.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.employee.R
import com.example.employee.databinding.ZigzagItemBinding


class ZigZagAdapter(var context: Context) : RecyclerView.Adapter<ZigZagAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ZigzagItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ZigzagItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (position==0){

            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.zigzak))
        }
        if (position==1){

            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.white))
        }
        if (position==2){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.white))
        }

        if (position==3){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.zigzak))
        }

        if (position==4){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.zigzak))
        }

        if (position==5){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.white))
        }

        if (position==6){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.white))
        }

        if (position==7){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.zigzak))
        }

        if (position==8){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.white))
        }
        if (position==8){
            holder.binding.zigzag.setBackgroundTintList(context.getResources().getColorStateList(R.color.zigzak))
        }

    }

    override fun getItemCount(): Int {
        return 10
    }
}