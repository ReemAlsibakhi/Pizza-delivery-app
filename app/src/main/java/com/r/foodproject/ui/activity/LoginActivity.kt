package com.r.foodproject.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.r.foodproject.Main2Activity
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

       // val data=intent
//        val flag=data.getStringExtra("flag")
//         if(flag == "signup"){
//             edit.putString(AppConstants.NAME, data.getStringExtra("name"))
//             edit.putString(AppConstants.IMAGE, data.getStringExtra("img"))
//             val b = edit.commit()
//             if (b) {
//                // Toast.makeText(this, "get data Successfully", Toast.LENGTH_LONG).show()
//                 Log.e("reem",b.toString())
//             } else
//                 Toast.makeText(this, "add failed", Toast.LENGTH_LONG).show()
//         }

        btn_login.setOnClickListener {
            if (first_Name.text.isEmpty() && last_name.text.isEmpty() && email.text.isEmpty() && password.text.isEmpty()) {
                Toast.makeText(this, "Please enter data", Toast.LENGTH_LONG).show()
            } else {
                var first_Name = first_Name.text.toString()
                var last_name = last_name.text.toString()
                var e_mail = email.text.toString()
                var pwd = password.text.toString()

                edit.putBoolean(AppConstants.ISLOGIN, true)
                val d = db.addUser(first_Name, last_name, e_mail, pwd)
                val id_user= db.userAuth(e_mail,pwd)
                edit.putString(AppConstants.FIRSTNAME, AppConstants.FIRSTNAME)
                edit.putString(AppConstants.LASTNAME, AppConstants.LASTNAME)
                edit.putString(AppConstants.EMAIL, AppConstants.EMAIL)
                edit.putInt(AppConstants.USER_ID, id_user)
                val a = edit.commit()
              if (a)
                   Toast.makeText(this, "add id user success +$id_user", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this, "add id user failed", Toast.LENGTH_LONG).show()

                val i = Intent(this, Main2Activity::class.java)
                startActivity(i)
                finish()

            }
        }
    }}



//            val email=email.text.toString()
//            val pwd=password.text.toString()
//            if(email.isEmpty() &&  pwd.isEmpty()){
//                Toast.makeText(this, "Please enter login data", Toast.LENGTH_LONG).show()
//            }else{
//
//                val d= db.userAuth(email,pwd)
//                edit.putBoolean(AppConstants.ISLOGIN, true)
//                edit.putInt(AppConstants.USER_ID, d)
//                val a = edit.commit()
//                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
//
//                val i= Intent(this, MainActivity::class.java)
//                startActivity(i)
//                finish()
//                if (a)
//                    Toast.makeText(this, "add success", Toast.LENGTH_LONG).show()
//                else
//                    Toast.makeText(this, "add failed", Toast.LENGTH_LONG).show()
//
//            }


        //  root.btn_login
//        signup.setOnClickListener {
//            val i= Intent(this, LoginActivity::class.java)
//            startActivity(i)
//            //    requireActivity().finish()
//        }



