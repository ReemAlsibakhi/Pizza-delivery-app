package com.r.foodproject.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.r.foodproject.Main2Activity
import com.r.foodproject.R
import com.r.foodproject.ui.model.AppConstants
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sp =getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)
        val is_login=sp.getBoolean(AppConstants.ISLOGIN,false)

        Handler().postDelayed({
            if (is_login==true){
                val i = Intent(this,Main2Activity::class.java)
                startActivity(i)
                finish()
            }else{
                val i = Intent(this,LoginActivity::class.java)
                startActivity(i)
                finish()
            }

        },2000)


        startAnim()
    }
    fun startAnim() {
        avi.show()
        // or avi.smoothToShow();
    }

    fun stopAnim() {
        avi.hide()
        // or avi.smoothToHide();
    }
    }
