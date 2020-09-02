package com.r.foodproject.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.r.foodproject.R
import com.r.foodproject.ui.model.AppConstants
import com.r.foodproject.ui.model.DatabaseHelper
import kotlinx.android.synthetic.main.activity_sign_in.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val db = DatabaseHelper(this)
        val sp =getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)
        val edit = sp.edit()

        val data=intent
        val flag=data.getStringExtra("flag")
         if(flag == "signup"){
             edit.putString(AppConstants.NAME, data.getStringExtra("name"))
             edit.putString(AppConstants.IMAGE, data.getStringExtra("img"))
             val b = edit.commit()
             if (b) {
                // Toast.makeText(this, "get data Successfully", Toast.LENGTH_LONG).show()
                 Log.e("reem",b.toString())
             } else
                 Toast.makeText(this, "add failed", Toast.LENGTH_LONG).show()
         }

        btn_login.setOnClickListener {
            val email=email.text.toString()
            val pwd=password.text.toString()
            if(email.isEmpty() &&  pwd.isEmpty()){
                Toast.makeText(this, "Please enter login data", Toast.LENGTH_LONG).show()
            }else{

                val d= db.userAuth(email,pwd)
                edit.putBoolean(AppConstants.ISLOGIN, true)
                edit.putInt(AppConstants.USER_ID, d)
                val a = edit.commit()
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()

                val i= Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
                if (a)
                    Toast.makeText(this, "add success", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this, "add failed", Toast.LENGTH_LONG).show()

            }
        }

        //  root.btn_login
//        signup.setOnClickListener {
//            val i= Intent(this, LoginActivity::class.java)
//            startActivity(i)
//            //    requireActivity().finish()
//        }
    }

}
