package com.r.foodproject.ui.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.r.foodproject.R
import com.r.foodproject.ui.model.DatabaseHelper
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import com.vansuita.pickimage.listeners.IPickResult
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_add_product.pick_img

class AddProductActivity : AppCompatActivity(), IPickResult {
    var ImageURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        pick_img.setOnClickListener {
            PickImageDialog.build(PickSetup()).show(this)
        }

        btn_add.setOnClickListener {

            var name = tv_nameProduct.text.toString()
            var description = tv_description.text.toString()
            var amount = tv_amount.text.toString()
            var price = tv_price.text.toString()
            var rating = tv_rate.numStars.toString()
            var spinner = sp_categories.selectedItemPosition

            if (name.isEmpty() || description.isEmpty() || tv_amount.text.toString().isEmpty()
                || tv_price.text.toString().isEmpty() || tv_rate.numStars.toString().isEmpty()
            ) {
                Toast.makeText(this, "Pleaze add product", Toast.LENGTH_LONG).show()
            } else {

                val db = DatabaseHelper(this)
                Toast.makeText(
                    this,
                    "$name, $description, $amount ,$price, $rating, $spinner ",
                    Toast.LENGTH_LONG
                ).show()
                db.addProduct(
                    name,
                    description,
                    amount.toInt(),
                    price.toDouble(),
                    0,
                    ImageURI.toString(),
                    rating.toInt(),
                    spinner
                )
                finish()
            }


        }
    }

    override fun onPickResult(r: PickResult?) {
        if (r!!.error == null) {
            img_product.setImageURI(r.uri)
            ImageURI = r.uri
        }
    }
}
