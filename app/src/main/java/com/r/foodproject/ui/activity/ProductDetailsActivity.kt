package com.r.foodproject.ui.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.r.foodproject.R
import com.r.foodproject.ui.model.AppConstants
import com.r.foodproject.ui.model.DatabaseHelper
import com.r.foodproject.ui.model.Price
import kotlinx.android.synthetic.main.activity_product_details.*
import java.util.ArrayList

class ProductDetailsActivity : AppCompatActivity() {
    var sp:SharedPreferences ?=null
    val quantity:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val db = DatabaseHelper(this)
         sp = getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)

        val data = intent
        val id = data.getIntExtra("id", -1)

        val prod_name = data.getStringExtra("name")
        val prod_desc = data.getStringExtra("description")
        val prod_img = data.getStringExtra("img")
        val price = data.getStringExtra("price")

        tv_name.text = prod_name
        tv_description.text = prod_desc
        tv_num.text = data.getStringExtra("amout")
        tv_price.text = price.toString()
        img_product.setImageResource(prod_img.toInt())
        val is_Fav = data.getIntExtra("isFav", -1)


        save.setOnClickListener {
            if (is_Fav == 0) {
                val b = db.save(id)
                if (b)
                    Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this, "Save Failed", Toast.LENGTH_LONG).show()
            } else if (is_Fav == 1) {
                Toast.makeText(this, "it has already been saved", Toast.LENGTH_LONG).show()

            }

        }
        //cart
        btn_cart.setOnClickListener {

         val  sp = getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)

            val id_user = sp.getInt(AppConstants.USER_ID, -1)
           Toast.makeText(applicationContext,"$id_user",Toast.LENGTH_LONG).show()
            val ord = db.addOrder(id, id_user, prod_name, prod_img.toString(), price.toDouble())
            val pri=db.addPrices(price.toDouble())
            if (ord)
                Toast.makeText(
                    this,
                    "Added to cart+ $pri +$id + $id_user +$prod_name +$prod_img+ $price ",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    this,
                    "failed +$id+$id_user +$prod_name +$prod_img+ $price ",
                    Toast.LENGTH_LONG
                ).show()


        }
        var num=tv_num.text.toString().toInt()

        minus.setOnClickListener {
            num-=1
            tv_num.text=num.toString()
        }
        plus.setOnClickListener {
            num+=1
            tv_num.text=num.toString()

        }

    }
}
