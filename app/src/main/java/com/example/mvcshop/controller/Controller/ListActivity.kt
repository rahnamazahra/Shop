package com.example.mvcshop.controller.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvcshop.R
import com.example.mvcshop.controller.Adapter.CategoryAdapter
import com.example.mvcshop.controller.Adapter.CategoryRecyclerView
import com.example.mvcshop.controller.Services.DataSource
import com.example.mvcshop.databinding.ActivityListBinding

private lateinit var binding:ActivityListBinding
class ListActivity : AppCompatActivity() {
    //  private lateinit var adapter:ArrayAdapter<String>
        private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val data = DataSource()
         adapter = CategoryAdapter(this, data.categories)

        adapter = CategoryAdapter(this, data.categories)
        binding.listCategories.adapter = adapter




//        val categories=listOf<String>(
//            "shirt",
//            "hat"
//        )
//
//        adapter=ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,categories)
//        binding.listCategories.adapter=adapter



    }
}