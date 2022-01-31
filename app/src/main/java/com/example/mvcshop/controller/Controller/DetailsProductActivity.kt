package com.example.mvcshop.controller.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvcshop.R
import com.example.mvcshop.controller.Utilities.EXTRA_PRODUCT
import com.example.mvcshop.databinding.ActivityDetailsProductBinding

private lateinit var binding:ActivityDetailsProductBinding
class DetailsProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item=intent.getStringExtra(EXTRA_PRODUCT)
        binding.TitleProduct.text=item
    }
}