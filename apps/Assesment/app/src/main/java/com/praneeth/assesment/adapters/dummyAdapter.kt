package com.praneeth.assesment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.praneeth.assesment.R
import com.praneeth.assesment.model.DataItem

class dummyAdapter(val dataList: MutableList<DataItem>) : RecyclerView.Adapter<dummyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dummyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.dummy_item_layout,parent,false)
        return dummyViewHolder(view)
    }

    override fun onBindViewHolder(holder: dummyViewHolder, position: Int) {


        holder.apply {

            tvName.text= "Name :" + dataList[position].employeeName
            tvID.text= "Id :" + dataList[position].id
            tvSalary.text= "Salary :" + dataList[position].employeeSalary
            tvAge.text= "Name :" + dataList[position].employeeAge

        }
    }

    override fun getItemCount(): Int {
       return  dataList.size
    }
}


class dummyViewHolder(val view: View): RecyclerView.ViewHolder(view){

   var tvName = view.findViewById<TextView>(R.id.tvName)
   var tvAge = view.findViewById<TextView>(R.id.tvAge)
   var tvSalary = view.findViewById<TextView>(R.id.tvSalary)
   var tvID = view.findViewById<TextView>(R.id.tvId)


}