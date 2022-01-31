package com.example.mvcshop.controller.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mvcshop.R
import com.example.mvcshop.controller.Model.Category
import javax.sql.DataSource

class CategoryAdapter(val _context: Context, val _categories: List<Category>) : BaseAdapter() {

    override fun getCount(): Int {
        return _categories.count()
    }

    override fun getItem(position: Int): Any {
        return _categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutItem: View
        val holder: ViewHolder

        if (convertView == null) {

            holder = ViewHolder()

            layoutItem = LayoutInflater.from(_context).inflate(R.layout.custom_item_list, null)

            holder.img_category = layoutItem.findViewById(R.id.img_category)
            holder.title_category = layoutItem.findViewById(R.id.title_category)

            layoutItem?.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
            layoutItem = convertView
        }

        val category = _categories[position]
        val resourceId =
            _context.resources.getIdentifier(category.img, "drawable", _context.packageName)
        holder.img_category?.setImageResource(resourceId)
        holder.title_category?.text = category.title
        layoutItem.setOnClickListener { println(category.title) }
        return layoutItem
    }


    class ViewHolder() {
        var img_category: ImageView? = null
        var title_category: TextView? = null
    }
}