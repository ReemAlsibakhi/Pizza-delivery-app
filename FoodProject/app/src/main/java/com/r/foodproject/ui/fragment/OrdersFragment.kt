package com.r.foodproject.ui.fragment

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.r.foodproject.R
import com.r.foodproject.ui.adapter.OrderAdapter
import com.r.foodproject.ui.model.AppConstants
import com.r.foodproject.ui.model.DatabaseHelper
import com.r.foodproject.ui.model.Orders
import kotlinx.android.synthetic.main.fragment_orders.*
import kotlinx.android.synthetic.main.fragment_orders.view.*

class OrdersFragment : Fragment() {
 //    var order_list:ArrayList<Orders>()
    //var data:ArrayList<Orders> ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_orders, container, false)


    return  root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db= DatabaseHelper(requireContext())

        val sp = requireActivity().getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)
        val id_user=sp.getInt(AppConstants.USER_ID,-1)
        val login = sp.getBoolean(AppConstants.ISLOGIN, false)

        val order_list=db.getOrder(id_user)

        if(login && order_list.size > 0){
            Log.e("rem", order_list.size.toString())
            rv_order.layoutManager = LinearLayoutManager(requireContext())
            val adapter = OrderAdapter(requireActivity(), order_list)
            rv_order.adapter = adapter
            adapter.notifyDataSetChanged()
            if( tv_notFound.isVisible){
                tv_notFound.visibility=View.GONE
            }
        }else {
            if( ! tv_notFound.isVisible){
                tv_notFound.visibility=View.VISIBLE
            }
            }
        }
        }
//   fun showText(){
//       if( ! tv_notFound.isVisible){
//           tv_notFound.visibility=View.VISIBLE
//   }}
//       fun hideText(){
//           if( tv_notFound.isVisible){
//               tv_notFound.visibility=View.GONE
//           } }


