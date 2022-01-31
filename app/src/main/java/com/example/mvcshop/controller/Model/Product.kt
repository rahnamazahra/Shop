package com.example.mvcshop.controller.Model

class Product(val title:String,val price:String,var img:String){


    override fun toString(): String {
        return title
    }
}