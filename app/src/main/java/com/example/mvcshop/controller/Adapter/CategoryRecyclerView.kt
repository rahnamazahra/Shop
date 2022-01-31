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

class CategoryRecyclerView(val context: Context, val categories: List<Category>,val clickedItem:(Category)->Unit) :
    RecyclerView.Adapter<CategoryRecyclerView.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=LayoutInflater.from(context).inflate(R.layout.custom_item_list,parent,false)
        return Holder(view,clickedItem)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.bindCategory(categories[position],context)
    }

    override fun getItemCount(): Int {
       return categories.count()
    }

    inner class Holder(itemView: View,val clickedItem:(Category)->Unit) : RecyclerView.ViewHolder(itemView) {
        val imageCategory=itemView.findViewById<ImageView>(R.id.img_category)
        val titleCategory=itemView.findViewById<TextView>(R.id.title_category)

        fun bindCategory(category:Category,context:Context){
            titleCategory.text=category.title
            val resourceId=context.resources.getIdentifier(category.img,"drawable",context.packageName)
            imageCategory.setImageResource(resourceId)
            itemView.setOnClickListener { clickedItem(category) }
        }

    }
}