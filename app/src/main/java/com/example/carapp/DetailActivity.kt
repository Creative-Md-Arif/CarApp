package com.example.carapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.carapp.databinding.ActivityDetailBinding
import com.example.carapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val carName1 = intent.getStringExtra("name")
        val carPrice1 = intent.getDoubleExtra("price", 0.0)
        val carQnt1 = intent.getIntExtra("quantity", 0)
        val carImg1 = intent.getIntExtra("image", 0)
        val carDesc1 = intent.getStringExtra("desc")

        binding.apply {
            carName.text = carName1
            carPrice.text = "Price: $" + carPrice1.toString()
            carQnt.text = "Quantity: " + carQnt1.toString()
            carImg.setImageResource(carImg1)
            carDesc.text = carDesc1


        }

    }
}