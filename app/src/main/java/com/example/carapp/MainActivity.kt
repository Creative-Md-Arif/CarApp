package com.example.carapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carapp.adapter.CarAdapter
import com.example.carapp.databinding.ActivityMainBinding
import com.example.carapp.databinding.AddCarLayoutBinding
import com.example.carapp.model.Car

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var carAdapter : CarAdapter
    private val car = ArrayList<Car>()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.carRv.layoutManager = LinearLayoutManager(this)



        car.add(Car("carOne", 20, 4.0, R.drawable.carone ,"carOne"))
        car.add(Car("carTwo", 25, 100.0, R.drawable.cartwo , "carTwo"))
        car.add(Car("carTheree", 30, 10.0, R.drawable.cartheree , "carThree"))
        car.add(Car("carFour", 40, 20.0, R.drawable.carfour , "carFour"))
        car.add(Car("carFive", 10, 99.0, R.drawable.carfive, "carFive"))
        car.add(Car("carSix", 150, 120.0, R.drawable.carsix, "carSix"))
        car.add(Car("carSeven", 50, 500.0, R.drawable.carseven , "carSeven"))
        car.add(Car("carEight", 30, 1000.0, R.drawable.careight , "carEight"))
        car.add(Car("carNine", 20, 300.0, R.drawable.carnine, "carNine"))
        car.add(Car("carTen", 10, 200.0, R.drawable.carten , "carTen"))


        carAdapter = CarAdapter(car)
        binding.carRv.adapter = carAdapter


        carAdapter.onClick={

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.carName)
            intent.putExtra("price", it.carPrice)
            intent.putExtra("quantity", it.carQnt)
            intent.putExtra("desc", it.carDesc)
            intent.putExtra("image", it.carImg)
            startActivity(intent)
        }
        binding.addBtn.setOnClickListener{
            showCarAddDialog()
        }
    }

    private fun showCarAddDialog() {
      val dialogView = LayoutInflater.from(this).inflate(R.layout.add_car_layout, null)
        val nameEt = dialogView.findViewById<EditText>(R.id.carNameEt)
        val priceEt = dialogView.findViewById<EditText>(R.id.carPriceEt)
        val qntEt = dialogView.findViewById<EditText>(R.id.carQntEt)
        val descEt = dialogView.findViewById<EditText>(R.id.carDescEt)



        AlertDialog.Builder(this)
            .setTitle("Add Car")
            .setView(dialogView)
            .setPositiveButton("Add"){_,_ ->
                val carName = nameEt.text.toString()
                val carPrice = priceEt.text.toString().toDouble()
                val carQnt = qntEt.text.toString().toInt()
                val carDesc = descEt.text.toString()
                val carImg = R.drawable.carone
                car.add(Car(carName, carQnt, carPrice, carImg, carDesc))
                carAdapter.notifyItemChanged(car.size -1)
            }
            .setNegativeButton("Cancel" , null)
            .show()
    }
}


