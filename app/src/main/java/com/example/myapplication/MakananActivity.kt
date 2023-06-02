package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.entity.User

class MakananActivity : AppCompatActivity() {
    var hargaKentangGoreng = 8000;
    var hargaOmlet = 12000;
    var hargaSosis = 10000;
    var hargaTahuWalik = 10000;
    var hargaRotiBakar = 22000;
    var countKentangGoreng = 0;
    var countOmlet = 0;
    var countSosis = 0;
    var countTahuWalik = 0;
    var countRotiBakar = 0;
    var totalItems = 0;
    var totalPrice = 0;
    var jmlKentangGoreng = 0;
    var jmlOmlet = 0;
    var jmlSosis = 0;
    var jmlTahuWalik = 0
    var jmlRotiBakar  = 0
    var hargaTotalKentangGoreng = 0;
    var hargaTotalOmlet = 0;
    var hargaTotalSosis = 0;
    var hargaTotalTahuWalik = 0;
    var hargaTotalRotiBakar = 0;
    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)
        database = AppDatabase.getInstance(applicationContext)
        setJmlMakanan()

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

    private fun setJmlMakanan() {
        val imageAdd1 = findViewById<ImageView>(R.id.imageAdd1)
        val imageMinus1 = findViewById<ImageView>(R.id.imageMinus1)
        val tvHargaKentangGoreng = findViewById<TextView>(R.id.tvKentangGoreng)

        val imageAdd2 = findViewById<ImageView>(R.id.imageAdd2)
        val imageMinus2 = findViewById<ImageView>(R.id.imageMinus2)
        val tvHargaOmlet = findViewById<TextView>(R.id.tvomlet)

        val imageAdd3 = findViewById<ImageView>(R.id.imageAdd3)
        val imageMinus3 = findViewById<ImageView>(R.id.imageMinus3)
        val tvHargaSosis = findViewById<TextView>(R.id.tvsosis)

        val imageAdd4 = findViewById<ImageView>(R.id.imageAdd4)
        val imageMinus4 = findViewById<ImageView>(R.id.imageMinus4)
        val tvHargaTahuWalik = findViewById<TextView>(R.id.tvTahuWalik)

        val imageAdd5 = findViewById<ImageView>(R.id.imageAdd5)
        val imageMinus5 = findViewById<ImageView>(R.id.imageMinus5)
        val tvHargaRotiBakar = findViewById<TextView>(R.id.tvRotiBakar)

        //add item
        imageAdd1.setOnClickListener {
            countKentangGoreng = countKentangGoreng + 1
            tvHargaKentangGoreng.text = countKentangGoreng.toString()
            jmlKentangGoreng = countKentangGoreng.toInt()
            hargaTotalKentangGoreng = hargaKentangGoreng * jmlKentangGoreng
            setTotalPrice()
        }

        //min item
        imageMinus1.setOnClickListener {
            if (countKentangGoreng > 0) {
                countKentangGoreng = countKentangGoreng - 1
                tvHargaKentangGoreng.text = countKentangGoreng.toString()
            }
            jmlKentangGoreng = countKentangGoreng.toInt()
            hargaTotalKentangGoreng = hargaKentangGoreng * jmlKentangGoreng
            setTotalPrice()
        }

        //add item
        imageAdd2.setOnClickListener {
            countOmlet = countOmlet + 1
            tvHargaOmlet.text = countOmlet.toString()
            jmlOmlet = countOmlet.toInt()
            hargaTotalOmlet = hargaOmlet * jmlOmlet
            setTotalPrice()
        }

        //min item
        imageMinus2.setOnClickListener {
            if (countOmlet > 0) {
                countOmlet = countOmlet - 1
                tvHargaOmlet.text = countOmlet.toString()
            }
            jmlOmlet = countOmlet.toInt()
            hargaTotalOmlet = hargaOmlet * jmlOmlet
            setTotalPrice()
        }

        //add item
        imageAdd3.setOnClickListener {
            countSosis = countSosis + 1
            tvHargaSosis.text = countSosis.toString()
            jmlSosis = countSosis.toInt()
            hargaTotalSosis = hargaSosis * jmlSosis
            setTotalPrice()
        }

        //min item
        imageMinus3.setOnClickListener {
            if (countSosis > 0) {
                countSosis = countSosis - 1
                tvHargaSosis.text = countSosis.toString()
            }
            jmlSosis = countSosis.toInt()
            hargaTotalSosis = hargaSosis * jmlSosis
            setTotalPrice()
        }

        //add item
        imageAdd4.setOnClickListener {
            countTahuWalik = countTahuWalik + 1
            tvHargaTahuWalik.text = countTahuWalik.toString()
            jmlTahuWalik = countTahuWalik.toInt()
            hargaTotalTahuWalik = hargaTahuWalik * jmlTahuWalik
            setTotalPrice()
        }

        //min item
        imageMinus4.setOnClickListener {
            if (countTahuWalik > 0) {
                countTahuWalik = countTahuWalik - 1
                tvHargaTahuWalik.text = countTahuWalik.toString()
            }
            jmlTahuWalik = countTahuWalik.toInt()
            hargaTotalTahuWalik = hargaTahuWalik * jmlTahuWalik
            setTotalPrice()
        }

        //add item
        imageAdd5.setOnClickListener {
            countRotiBakar = countRotiBakar + 1
            tvHargaRotiBakar.text = countRotiBakar.toString()
            jmlRotiBakar = countRotiBakar.toInt()
            hargaTotalRotiBakar = hargaRotiBakar * jmlRotiBakar
            setTotalPrice()
        }

        //min item
        imageMinus5.setOnClickListener {
            if (countRotiBakar > 0) {
                countRotiBakar = countRotiBakar - 1
                tvHargaRotiBakar.text = countRotiBakar.toString()
            }
            jmlRotiBakar = countRotiBakar.toInt()
            hargaTotalRotiBakar = hargaRotiBakar * jmlRotiBakar
            setTotalPrice()
        }
    }

    private fun setTotalPrice() {
        val tvJumlahBarang = findViewById<TextView>(R.id.tvJumlahBarang)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        totalItems = jmlKentangGoreng + jmlOmlet + jmlSosis + jmlTahuWalik + jmlRotiBakar
        totalPrice = hargaTotalKentangGoreng + hargaTotalOmlet + hargaTotalSosis + hargaTotalTahuWalik + hargaTotalRotiBakar

        tvJumlahBarang.setText("$totalItems items")
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice))
    }
    private fun setInputData() {
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener(View.OnClickListener {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(
                    this@MakananActivity,
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
                    this@MakananActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        })
    }
}