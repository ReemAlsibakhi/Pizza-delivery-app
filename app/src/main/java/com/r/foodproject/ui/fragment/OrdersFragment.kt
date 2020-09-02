package com.r.foodproject.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.r.foodproject.R
import com.r.foodproject.ui.adapter.OrderAdapter
import com.r.foodproject.ui.model.AppConstants
import com.r.foodproject.ui.model.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_orders.*
import kotlinx.android.synthetic.main.fragment_orders.view.*

class OrdersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_orders, container, false)


     root.map.setOnClickListener {
         val i=Intent(requireActivity(),MapsActivity::class.java)
         requireActivity().startActivity(i)
     }
        root.btn_orderNow.setOnClickListener {
            Toast.makeText(requireContext(),"Order send successully",Toast.LENGTH_LONG).show()

        }
        val db= DatabaseHelper(requireContext())

//        val price_list=db.getPrices()
//        Toast.makeText(requireContext(),"${price_list.size}",Toast.LENGTH_LONG).show()
//        var num=0.0
//        for (i in 0 until price_list.size ){
//            num += price_list[i].price
//
//        }
//        root.total_price.text=num.toString()
    return  root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db= DatabaseHelper(requireContext())

        val sp = requireActivity().getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)
        val id_user=sp.getInt(AppConstants.USER_ID,-1)

        val order_list=db.getOrder(id_user)

        if(order_list.size > 0){
            Log.e("rem", order_list.size.toString())
            rv_order.layoutManager = LinearLayoutManager(requireContext())
            val adapter = OrderAdapter(requireActivity(), order_list)
            rv_order.adapter = adapter
            adapter.notifyDataSetChanged()
            if( tv_notFound.isVisible){
                tv_notFound.visibility=View.GONE
                linear1.visibility=View.VISIBLE
            }
        }else {
            if( ! tv_notFound.isVisible){
                tv_notFound.visibility=View.VISIBLE
                linear1.visibility=View.GONE
            }
            }

        }
        }



