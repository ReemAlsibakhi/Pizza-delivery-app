package com.r.foodproject.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.r.foodproject.R
import com.r.foodproject.ui.adapter.BurgerAdapter
import com.r.foodproject.ui.adapter.DessertAdapter
import com.r.foodproject.ui.adapter.PizzaAdapter
import com.r.foodproject.ui.model.DatabaseHelper
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.content_catagory.*
import kotlinx.android.synthetic.main.toolbar_categories.*

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val db = DatabaseHelper(this)
        val data = intent
        var flag = data.getStringExtra("flag")

        img_back.setOnClickListener {
            finish()
        }
        if (flag == "burger") {
            tv_title.setText("Burgers")
            val burgers_list = db.getBurger()
            rv_products.layoutManager = LinearLayoutManager(this)
            val adapter = BurgerAdapter(this, burgers_list)
            rv_products.adapter = adapter
            adapter.notifyDataSetChanged()
        } else if (flag == "pizza") {

            tv_title.setText("Pizza")
            val pizza_list = db.getPizza()
            rv_products.layoutManager = LinearLayoutManager(this)
            val adapter = PizzaAdapter(this, pizza_list)
            rv_products.adapter = adapter
            adapter.notifyDataSetChanged()

        } else if (flag == "dessert") {
            tv_title.setText("Dessert")
            val dessert_list = db.getDessert()
            rv_products.layoutManager = LinearLayoutManager(this)
            val adapter = DessertAdapter(this, dessert_list)
            rv_products.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        fab_add.setOnClickListener {
            val i = Intent(this, AddProductActivity::class.java)
            startActivity(i)

        }

    }
}


