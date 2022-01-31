package com.example.mvcshop.controller.Services

import com.example.mvcshop.controller.Model.Category
import com.example.mvcshop.controller.Model.Product

class DataSource(){
    val categories= listOf(
        Category("SHIRT","shirtimage"),
        Category("HAT","hatimage"),
        Category("HOODIE","hoodieimage"),
        Category("DIGITAL","digitalgoodsimage") ,

    )


    val shirts= listOf(
        Product("shirt 1 ","150,000","shirt1"),
        Product("shirt 2 ","150,000","shirt2"),
        Product("shirt 3 ","150,000","shirt3"),
        Product("shirt 4 ","150,000","shirt4"),
    )

    val hats=listOf(
        Product("hat 1","110,000","hat1"),
        Product("hat 2","110,000","hat2"),
        Product("hat 3","110,000","hat3"),
        Product("hat 4","110,000","hat4"),
    )

    val hoodies=listOf(
        Product("hoodie 1","255,000","hoodie1"),
        Product("hoodie 2","255,000","hoodie2"),
        Product("hoodie 3","255,000","hoodie3"),
        Product("hoodie 4","255,000","hoodie4"),
    )

  val digital= listOf<Product>()

    fun getListProduct(NameCategory:String):List<Product>{
       return when(NameCategory){
            "SHIRT"->shirts
            "HAT"->hats
            "HOODIE"->hoodies
           else->digital
        }
    }
}