package com.example.carapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp.model.Car
import com.example.carapp.databinding.CarItemBinding

class CarAdapter(private val carList:ArrayList<Car>): RecyclerView.Adapter<CarAdapter.MyViewHolder>() {
    var onClick :((Car) -> Unit) ?= null
    class MyViewHolder(val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = CarItemBinding.inflate(
          LayoutInflater.from(parent.context),
            parent
            attachToParent false
        )
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            carName.text = carList[position].carName
            carQnt.text = "Quantity:" + carList[position].carQnt.toString()
            carPrice.text = "Price: $" + carList[position].carPrice.toString()
            carImg.setImageResource(carList[position].carImg)
        }
        holder.itemView.setOnClickListener{
            onClick?.invoke(carList[position])
        }

    }


}