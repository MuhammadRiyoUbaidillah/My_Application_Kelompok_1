package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.entity.User

class EditActivity : AppCompatActivity() {
    private lateinit var totalItem: EditText
    private lateinit var totalPrice: EditText
    private lateinit var btnSave : Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        totalItem = findViewById(R.id.et_total_item)
        totalPrice = findViewById(R.id.et_total_price)
        btnSave = findViewById(R.id.btn_save)
        database = AppDatabase.getInstance(applicationContext)
        val intent = intent.extras
        if (intent!=null){
            val id = intent.getInt("id",0)
            var user = database.userDao().get(id)

            totalItem.setText(user.totalItem!!.toString())
            totalPrice.setText(user.totalPrices!!.toString())
        }
        btnSave.setOnClickListener{
            if(totalPrice.text.isNotEmpty() && totalItem.text.isNotEmpty()){
                if (intent!=null){
                    database.userDao().update(
                        User(
                            intent.getInt("id",0),
                            totalItem.text.toString().toIntOrNull(),
                            totalPrice.text.toString().toIntOrNull()
                        )
                    )
                }
            }
            finish()
        }
    }
}