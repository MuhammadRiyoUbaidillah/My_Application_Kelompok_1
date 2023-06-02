package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val layoutMakanan = view.findViewById<CardView>(R.id.cvmakanan)
        val layoutMinuman = view.findViewById<CardView>(R.id.cvminuman)
        layoutMakanan.setOnClickListener{
            val intent = Intent(requireActivity(), MakananActivity::class.java)
            startActivity(intent)
        }
        layoutMinuman.setOnClickListener{
            val intent = Intent(requireActivity(), MinumanActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}
