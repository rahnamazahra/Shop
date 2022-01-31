package com.example.mvcshop.controller.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvcshop.R
import com.example.mvcshop.controller.Adapter.ProductAdapter
import com.example.mvcshop.controller.Model.Product
import com.example.mvcshop.controller.Services.DataSource
import com.example.mvcshop.controller.Utilities.EXTRA_CATEGORY
import com.example.mvcshop.controller.Utilities.EXTRA_PRODUCT
import com.example.mvcshop.databinding.ActivityProductBinding

private  lateinit var binding:ActivityProductBinding
class ProductActivity : AppCompatActivity() {
    private lateinit var adapter:ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)


//      setSupportActionBar(binding.toolbar)
//        supportActionBar!!.title="Category HATS"
//        supportActionBar!!.setLogo(R.drawable.ic_baseline_checkroom_24)

        val categoryType=intent.getStringExtra(EXTRA_CATEGORY)
        val data=DataSource()
        adapter= ProductAdapter(this,data.getListProduct(categoryType.toString())){item->
            val intentDetails= Intent(this,DetailsProductActivity::class.java)
            intentDetails.putExtra(EXTRA_PRODUCT, item.title)
            startActivity(intentDetails)

        }
        binding.listProducts.adapter=adapter

        var spanCount:Int
        val orientation=resources.configuration.orientation
        spanCount = if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            3
        }else{
            2
        }

        val sizeScreen=resources.configuration.screenWidthDp
        if(sizeScreen>720) {
            spanCount = if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                3
            } else {
                4
            }
        }

        val layoutmanager=GridLayoutManager(this,spanCount)
        binding.listProducts.layoutManager=layoutmanager
        binding.listProducts.setHasFixedSize(true)
    }
}


