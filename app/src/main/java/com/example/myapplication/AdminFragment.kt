package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.entity.User


class AdminFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
        database =AppDatabase.getInstance(requireContext().applicationContext)
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                val dialog = AlertDialog.Builder(requireContext())
                val totalItem = list[position].totalItem

                dialog.setItems(R.array.items_opsion, DialogInterface.OnClickListener{ dialog, which ->
                    if (which==0){
                        val intent = Intent(requireContext(), EditActivity::class.java)
                        intent.putExtra("id", list[position].uid)
                        startActivity(intent)
                    }else if(which==1){
                        database.userDao().delete(list[position])
                        getData()
                    }else{
                        dialog.dismiss()
                    }
                })
                val dialogView = dialog.create()
                dialogView.show()
            }

        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext
        , VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext().applicationContext, VERTICAL))
        return view
    }

    override fun onResume() {
        super.onResume()
        getData()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.userDao().getall())
        adapter.notifyDataSetChanged()
    }



}