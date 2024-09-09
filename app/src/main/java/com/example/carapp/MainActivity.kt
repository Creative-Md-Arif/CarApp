package com.example.carapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carapp.model.Car

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.carRv.layoutManager = LinearLayoutManager(this)
        val car = ArrayList<Car>()


        car.add(Car("carOne", 20, 4.0, R.drawable.carone ,"carOne"))
        car.add(Car("carTwo", 25, 100.0, R.drawable.cartwo , "carTwo"))
        car.add(Car("carOne", 30, 10.0, R.drawable.cartheree , "carThree"))
        car.add(Car("carOne", 40, 20.0, R.drawable.carfour , "carFour"))
        car.add(Car("carOne", 10, 99.0, R.drawable.carfive, "carFive"))
        car.add(Car("carOne", 150, 120.0, R.drawable.carsix, "carSix"))
        car.add(Car("carOne", 50, 500.0, R.drawable.carseven , "carSeven"))
        car.add(Car("carOne", 30, 1000.0, R.drawable.careight , "carEight"))
        car.add(Car("carOne", 20, 300.0, R.drawable.carnine, "carNine"))
        car.add(Car("carOne", 10, 200.0, R.drawable.carten , "carTen"))
        var carAdapter = CarAdapter(car)
        binding.carRv.adapter = carAdapter

        carAdapter.onClick={

        }
    }
}