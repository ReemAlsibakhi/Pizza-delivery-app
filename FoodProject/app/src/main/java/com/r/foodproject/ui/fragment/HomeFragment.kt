package com.r.foodproject.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.r.foodproject.R
import com.r.foodproject.ui.activity.ProductsActivity
import com.r.foodproject.ui.adapter.BurgerAdapter
import com.r.foodproject.ui.model.DatabaseHelper
import com.r.foodproject.ui.model.Product
import kotlinx.android.synthetic.main.content_catagory.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //  var  flag :String ?=null
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        root.card_burgers.setOnClickListener {
            val i= Intent(requireActivity(), ProductsActivity::class.java)
            i.putExtra("flag","burger")
            startActivity(i)
        }
            root.card_pizza.setOnClickListener {
            val i= Intent(requireActivity(),ProductsActivity::class.java)
            i.putExtra("flag","pizza")
            startActivity(i)
        }
            root.card_dessert.setOnClickListener {
            val i= Intent(requireActivity(),ProductsActivity::class.java)
            i.putExtra("flag","dessert")
            startActivity(i)
        }

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val burgers_list=ArrayList<Product>()
        burgers_list.add(Product(1,"Beef Burger with beetrot ","Beef Burger with beetrot klxdckl dkcvl",R.drawable.pizza,10, 90.3, 1, 1,4))
        burgers_list.add(Product(2,"Beef Burger with beetrot ","Beef Burger with beetrot klxdckl dkcvl",R.drawable.pizza,10, 19.3, 1, 1,4))
        burgers_list.add(Product(3,"Beef Burger with beetrot ","Beef Burger with beetrot klxdckl dkcvl",R.drawable.pizza,10, 16.3, 0, 1,4))
        burgers_list.add(Product(4,"Beef Burger with beetrot ","Beef Burger with beetrot klxdckl dkcvl",R.drawable.pizza,10, 14.3, 0, 1,4))
        burgers_list.add(Product(5,"Beef Burger with beetrot ","Beef Burger with beetrot klxdckl dkcvl",R.drawable.pizza,10, 12.3, 0, 1,4))
        rv_recommended.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BurgerAdapter(requireActivity(), burgers_list)
        rv_recommended.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
