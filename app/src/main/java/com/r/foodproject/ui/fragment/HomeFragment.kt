package com.r.foodproject.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.r.foodproject.R
import com.r.foodproject.ui.activity.AddProductActivity
import com.r.foodproject.ui.adapter.BurgerAdapter
import com.r.foodproject.ui.adapter.DessertAdapter
import com.r.foodproject.ui.adapter.PizzaAdapter
import com.r.foodproject.ui.adapter.ProductAdapter
import com.r.foodproject.ui.model.DatabaseHelper
import com.r.foodproject.ui.model.Product
import kotlinx.android.synthetic.main.content_catagory.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(),AdapterView.OnItemSelectedListener {
    var  db :DatabaseHelper ?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  var  flag :String ?=null
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        db = DatabaseHelper(requireContext())

//        root.card_burgers.setOnClickListener {
//            val i= Intent(requireActivity(), ProductsActivity::class.java)
//            i.putExtra("flag","burger")
//            startActivity(i)
//        }
//            root.card_pizza.setOnClickListener {
//            val i= Intent(requireActivity(),ProductsActivity::class.java)
//            i.putExtra("flag","pizza")
//            startActivity(i)
//        }
//            root.card_dessert.setOnClickListener {
//            val i= Intent(requireActivity(),ProductsActivity::class.java)
//            i.putExtra("flag","dessert")
//            startActivity(i)
//        }

        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categories,
          R.layout.spinner_text
        )
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        root.spinner.setAdapter(adapter);
        root.spinner.onItemSelectedListener = this
         root.fab_add.setOnClickListener {
             val i= Intent(requireActivity(), AddProductActivity::class.java)

            startActivity(i)
         }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = DatabaseHelper(requireContext())

        val burgers_list = ArrayList<Product>()
        burgers_list.add(
            Product(
                1,
                "Beef Burger with beetrot ",
                "Beef Burger with beetrot klxdckl dkcvl",
                R.drawable.burger3,
                10,
                90.3,
                1,
                1,
                4
            )
        )
        burgers_list.add(
            Product(
                2,
                "Beef Burger with beetrot ",
                "Beef Burger with beetrot klxdckl dkcvl",
                R.drawable.burger4,
                10,
                19.3,
                1,
                1,
                4
            )
        )
        burgers_list.add(
            Product(
                3,
                "Beef Burger with beetrot ",
                "Beef Burger with beetrot klxdckl dkcvl",
                R.drawable.burger6,
                10,
                16.3,
                0,
                1,
                4
            )
        )
        burgers_list.add(
            Product(
                4,
                "Beef Burger with beetrot ",
                "Beef Burger with beetrot klxdckl dkcvl",
                R.drawable.burger7,
                10,
                14.3,
                0,
                1,
                4
            )
        )
        burgers_list.add(
            Product(
                5,
                "Beef Burger with beetrot ",
                "Beef Burger with beetrot klxdckl dkcvl",
                R.drawable.burger8,
                10,
                12.3,
                0,
                1,
                4
            )
        )
        rv_product.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BurgerAdapter(requireActivity(), burgers_list)
        rv_product.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

     if(p0!!.getItemAtPosition(p2) =="Burger"){
         val burgers_list = db!!.getBurger()
         rv_product.layoutManager = LinearLayoutManager(requireContext())
         val adapter = BurgerAdapter(requireActivity(), burgers_list)
         rv_product.adapter = adapter
         adapter.notifyDataSetChanged()

     }else if(p0!!.getItemAtPosition(p2) =="Pizza"){
         val pizza_list = db!!.getPizza()
         rv_product.layoutManager = LinearLayoutManager(requireContext())
         val adapter = PizzaAdapter(requireActivity(), pizza_list)
         rv_product.adapter = adapter
         adapter.notifyDataSetChanged()
     }
     else if(p0!!.getItemAtPosition(p2) =="Dessert"){
         val dessert_list = db!!.getDessert()
         rv_product.layoutManager = LinearLayoutManager(requireContext())
         val adapter = DessertAdapter(requireActivity(), dessert_list)
         rv_product.adapter = adapter
         adapter.notifyDataSetChanged()
     }else{
         val product_list = db!!.getProducts()
         rv_product.layoutManager = LinearLayoutManager(requireContext())
         val adapter = ProductAdapter(requireActivity(), product_list)
         rv_product.adapter = adapter
         adapter.notifyDataSetChanged()
     }

    }

    }

