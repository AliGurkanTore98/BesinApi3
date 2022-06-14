package com.codingurkan.besinapi3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.besinapi3.databinding.RecyclerRowBinding
import com.codingurkan.besinapi3.model.FoodDataItem
import com.codingurkan.besinapi3.util.loadImage

class FoodAdapter(private val foodData : ArrayList<FoodDataItem>,
                  private val itemClickListener : ItemClickListener
                  ) : RecyclerView.Adapter<FoodAdapter.FoodVH>(){

    inner  class FoodVH(val binding: RecyclerRowBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodVH {
        val view = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FoodVH(view)
    }

    override fun onBindViewHolder(holder: FoodVH, position: Int) {

        with(holder.binding){
            ivGorsel.loadImage(foodData[position].gorsel!!)
            tvIsim.text = foodData[position].isim
            tvKalori.text = foodData[position].kalori
            tvKarbonhidrat.text = foodData[position].karbonhidrat
            tvProtein.text = foodData[position].protein
            tvYag.text = foodData[position].yag

            tvIsim.setOnClickListener {
                itemClickListener.clickText(foodData[position].isim!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return foodData.size
    }

    interface ItemClickListener{
        fun clickText(text : String)
    }
}