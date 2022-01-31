package com.example.mvcshop.controller.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvcshop.R
import com.example.mvcshop.controller.Model.Category
import com.example.mvcshop.controller.Model.Product

class ProductAdapter(val context: Context,val products:List<Product>,val clicked:(Product)->Unit):RecyclerView.Adapter<ProductAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

       val view=LayoutInflater.from(context).inflate(R.layout.item_product,parent,false)
        return Holder(view,clicked)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.bindProduct(products[position],context)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class Holder(itemView: View,val clicked: (Product) -> Unit) :RecyclerView.ViewHolder(itemView){

        var imageProduct=itemView.findViewById<ImageView>(R.id.img_product)
        var titleProduct=itemView.findViewById<TextView>(R.id.Title_product)
        var priceProduct=itemView.findViewById<TextView>(R.id.price_product)

        fun bindProduct(item: Product, context:Context){
            titleProduct.text=item.title
            priceProduct.text=item.price
            val resourceId=context.resources.getIdentifier(item.img,"drawable",context.packageName)
            imageProduct.setImageResource(resourceId)
            itemView.setOnClickListener { clicked (item)}
        }
    }
}