package com.example.mvcshop.controller.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvcshop.controller.Adapter.CategoryRecyclerView
import com.example.mvcshop.controller.Services.DataSource
import com.example.mvcshop.controller.Utilities.EXTRA_CATEGORY
import com.example.mvcshop.databinding.ActivityRecyclerviewBinding


private lateinit var binding: ActivityRecyclerviewBinding

class RecyclerViewActivity : AppCompatActivity() {

   private lateinit var adapter:CategoryRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val data = DataSource()
        adapter = CategoryRecyclerView(this, data.categories){category ->
            val intentProductPage= Intent(this,ProductActivity::class.java)
            intentProductPage.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(intentProductPage)
        }
        binding.listCategories.adapter = adapter

        val layoutManager=LinearLayoutManager(this)
        binding.listCategories.layoutManager=layoutManager
        binding.listCategories.setHasFixedSize(true )
    }
}