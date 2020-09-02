package com.r.foodproject.ui.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.r.foodproject.R
import com.r.foodproject.ui.activity.ProductDetailsActivity
import com.r.foodproject.ui.model.DatabaseHelper
import com.r.foodproject.ui.model.Orders
import kotlinx.android.synthetic.main.order_item.view.*

class OrderAdapter (var activity: Activity, var data:ArrayList<Orders>) :
    RecyclerView.Adapter<OrderAdapter.MyViewHolder>() {
     val db= DatabaseHelper(activity)

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item){
        var img=item.img_order
        var name= item.tv_orderName
        var price= item.tv_price
        var cardview=item.cardview

    }
    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(activity).inflate(R.layout.order_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img.setImageResource(data[position].img)
        holder.name.text = data[position].name
        holder.price.text = data[position].price.toString()

        holder.cardview.setOnLongClickListener {
            val alertDialog = AlertDialog.Builder(activity)
            alertDialog.setTitle("Delete Order")
            alertDialog.setMessage("Are you sure ?")
            alertDialog.setCancelable(false)
            alertDialog.setPositiveButton("Yes") { _, _ ->
             val d   =db.deleteOrder(data[position].id)
                if(d)
                    Toast.makeText(activity, "deleted", Toast.LENGTH_SHORT).show()
                  else
                    Toast.makeText(activity, "not deleted", Toast.LENGTH_SHORT).show()

                data.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,data.size)
              //  Toast.makeText(activity, "Deleted Successfully", Toast.LENGTH_SHORT).show()
            }
            alertDialog.setNegativeButton("No") { _, _ ->
                Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show()
            }


            alertDialog.create().show()
//        holder.cardview.setOnClickListener {
//            var bundle= Bundle()
//            bundle.putString("name",data[position].name)
//            bundle.putString("desc",data[position].desc)
//            bundle.putString("content",data[position].content)
//            bundle.putString("time",data[position].time)
//            bundle.putInt("rating",data[position].rating)
//            bundle.putString("fletter",holder.name.text.get(0).toString())
//            bundle.putInt("color",data[position].color)
//       //     it.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
//
//        }

            true
        }
    }
}
