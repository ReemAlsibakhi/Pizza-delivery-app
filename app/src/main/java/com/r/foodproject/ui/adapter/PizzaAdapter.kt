package com.r.foodproject.ui.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.r.foodproject.R
import com.r.foodproject.ui.activity.ProductDetailsActivity
import com.r.foodproject.ui.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class PizzaAdapter (var activity: Activity, var data:ArrayList<Product>) :
    RecyclerView.Adapter<PizzaAdapter.MyViewHolder>() {
    // val db=DatabaseHelper(activity)
    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item){
        var img=item.img_product
        var name= item.tv_name
        var price= item.tv_price
        var rate= item.tv_rate
        var cardview=item.cardview

    }
    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(activity).inflate(R.layout.product_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img.setImageResource(data[position].img)
        holder.name.text = data[position].name
        holder.price.text = data[position].price.toString()
        holder.rate.text = data[position].rate.toString()

     holder.cardview.setOnClickListener {

         val i= Intent(activity,ProductDetailsActivity::class.java)
         i.putExtra("id",data[position].id)
         i.putExtra("img",data[position].img.toString())
         i.putExtra("name",data[position].name.toString())
         i.putExtra("description",data[position].description.toString())
         i.putExtra("amout",data[position].pro_amount.toString())
         i.putExtra("price",data[position].price.toString())
         i.putExtra("isFav",data[position].is_fav)
         activity.startActivity(i)
     }
//        holder.cardview.setOnLongClickListener {
//            val alertDialog = AlertDialog.Builder(activity)
//            alertDialog.setTitle("Delete food")
//            alertDialog.setMessage("Are you sure ?")
//            alertDialog.setCancelable(false)
//            alertDialog.setPositiveButton("Yes") { _, _ ->
//                db.deleteFood(data[position].id)
//                data.removeAt(position)
//                notifyItemRemoved(position)
//                notifyItemRangeChanged(position,data.size)
//                Toast.makeText(activity, "Deleted", Toast.LENGTH_SHORT).show()
//            }
//            alertDialog.setNegativeButton("No") { _, _ ->
//                Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show()
//            }
//
////       alertDialog.setNeutralButton("Rate Me") { _, _ ->
////           Toast.makeText(activity, "Rate Me", Toast.LENGTH_SHORT).show()
//
//
//            alertDialog.create().show()
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
