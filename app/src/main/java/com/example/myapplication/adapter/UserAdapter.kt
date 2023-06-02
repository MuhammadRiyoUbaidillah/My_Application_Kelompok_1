package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog
    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }
    interface Dialog {
        fun onClick(position: Int)
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var totalItem: TextView
    var totalPrice: TextView

    init {
        totalItem = view.findViewById(R.id.tv_total_item)
        totalPrice = view.findViewById(R.id.tv_total_price)
        view.setOnClickListener{
            dialog.onClick(layoutPosition)
        }
    }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.totalItem.text = list[position].totalItem.toString()
        holder.totalPrice.text = list[position].totalPrices.toString()
    }
}