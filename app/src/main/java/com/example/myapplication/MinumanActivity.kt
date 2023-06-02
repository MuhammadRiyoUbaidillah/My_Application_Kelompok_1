package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.entity.User

class MinumanActivity : AppCompatActivity() {
    var hargakopihitam = 5000;
    var hargaesteh = 5000;
    var hargaleacytea = 15000;
    var hargacaffelate = 15000;
    var hargamatcha = 12000;
    var countkopihitam = 0;
    var countesteh = 0;
    var countleacytea = 0;
    var countcaffelate = 0;
    var countmatcha = 0;
    var totalItems = 0;
    var totalPrice = 0;
    var jmlkopihitam = 0;
    var jmlesteh = 0;
    var jmlleacytea = 0;
    var jmlcaffelate = 0;
    var jmlmatcha = 0;
    var hargatotalkopihitam = 0;
    var hargatotalesteh = 0;
    var hargatotalleacytea = 0;
    var hargatotalcaffelate = 0;
    var hargatotalmatcha = 0;
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minuman)
        database = AppDatabase.getInstance(applicationContext)
        setJmlMinuman()

        setInputData()
    }
    private fun setInitLayout() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)
        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        tvJumlahBarang.setText("0 items")
        tvTotalPrice.setText("Rp 0")
        tvInfo.setText("Harga sewaktu-waktu bisa berubah.")
    }

    private fun setJmlMinuman() {
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd6)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus6)
        val tvhargakopihitam = findViewById<TextView>(R.id.tvKopiHitam)

        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd7)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus7)
        val tvhargaesteh = findViewById<TextView>(R.id.tv_es_teh)

        val imageAdd3 = findViewById<ImageView>(R.id.imageAdd8)
        val imageMinus3 = findViewById<ImageView>(R.id.imageMinus8)
        val tvhargaleacytea = findViewById<TextView>(R.id.tv_leacy_tea)

        val imageAdd4 = findViewById<ImageView>(R.id.imageAdd9)
        val imageMinus4 = findViewById<ImageView>(R.id.imageMinus9)
        val tvhargacaffelate = findViewById<TextView>(R.id.tv_caffe_latte)

        val imageAdd5 = findViewById<ImageView>(R.id.imageAdd10)
        val imageMinus5 = findViewById<ImageView>(R.id.imageMinus10)
        val tvhargamatcha = findViewById<TextView>(R.id.tv_matcha)

        //add item
        imageAdd1.setOnClickListener {
            countkopihitam = countkopihitam + 1
            tvhargakopihitam.text = countkopihitam.toString()
            jmlkopihitam = countkopihitam.toInt()
            hargatotalkopihitam = hargakopihitam * jmlkopihitam
            setTotalPrice()
        }

        //min item
        imageMinus1.setOnClickListener {
            if (countkopihitam > 0) {
                countkopihitam = countkopihitam - 1
                tvhargakopihitam.text = countkopihitam.toString()
            }
            jmlkopihitam = countkopihitam.toInt()
            hargatotalkopihitam = hargakopihitam * jmlkopihitam
            setTotalPrice()
        }

        //add item
        imageAdd2.setOnClickListener {
            countesteh = countesteh + 1
            tvhargaesteh.text = countesteh.toString()
            jmlesteh = countesteh.toInt()
            hargatotalesteh = hargaesteh * jmlesteh
            setTotalPrice()
        }

        //min item
        imageMinus2.setOnClickListener {
            if (countesteh > 0) {
                countesteh = countesteh - 1
                tvhargaesteh.text = countesteh.toString()
            }
            jmlesteh = countesteh.toInt()
            hargatotalesteh = hargaesteh * jmlesteh
            setTotalPrice()
        }

        //add item
        imageAdd3.setOnClickListener {
            countleacytea = countleacytea + 1
            tvhargaleacytea.text = countleacytea.toString()
            jmlleacytea = countleacytea.toInt()
            hargatotalleacytea = hargaleacytea * jmlleacytea
            setTotalPrice()
        }

        //min item
        imageMinus3.setOnClickListener {
            if (countleacytea > 0) {
                countleacytea = countleacytea - 1
                tvhargaleacytea.text = countleacytea.toString()
            }
            jmlleacytea = countleacytea.toInt()
            hargatotalleacytea = hargaleacytea * jmlleacytea
            setTotalPrice()
        }

        //add item
        imageAdd4.setOnClickListener {
            countcaffelate = countcaffelate + 1
            tvhargacaffelate.text = countcaffelate.toString()
            jmlcaffelate = countcaffelate.toInt()
            hargatotalcaffelate = hargacaffelate * jmlcaffelate
            setTotalPrice()
        }

        //min item
        imageMinus4.setOnClickListener {
            if (countcaffelate > 0) {
                countcaffelate = countcaffelate - 1
                tvhargacaffelate.text = countcaffelate.toString()
            }
            jmlcaffelate = countcaffelate.toInt()
            hargatotalcaffelate = hargacaffelate * jmlcaffelate
            setTotalPrice()
        }

        //add item
        imageAdd5.setOnClickListener {
            countmatcha = countmatcha + 1
            tvhargamatcha.text = countmatcha.toString()
            jmlmatcha = countmatcha.toInt()
            hargatotalmatcha = hargamatcha * jmlmatcha
            setTotalPrice()
        }

        //min item
        imageMinus5.setOnClickListener {
            if (countmatcha > 0) {
                countmatcha = countmatcha - 1
                tvhargamatcha.text = countmatcha.toString()
            }
            jmlmatcha = countmatcha.toInt()
            hargatotalmatcha = hargamatcha * jmlmatcha
            setTotalPrice()
        }
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = jmlmatcha + jmlcaffelate + jmlesteh + jmlkopihitam + jmlleacytea
        totalPrice = hargatotalmatcha + hargatotalesteh + hargatotalcaffelate + hargatotalleacytea + hargatotalkopihitam

        tvJumlahBarang.setText("$totalItems items")
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }
    private fun setInputData() {
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener(View.OnClickListener {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(
                    this@MinumanActivity,
                    "Harap pilih jenis barang!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                database.userDao().insertAll(
                    User(
                        null,
                        totalItems,
                        totalPrice
                    )
                )
                Toast.makeText(
                    this@MinumanActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }
}