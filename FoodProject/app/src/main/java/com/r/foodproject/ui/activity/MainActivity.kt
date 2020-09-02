package com.r.foodproject.ui.activity

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.r.foodproject.ui.model.AppConstants
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_about, R.id.nav_orders, R.id.nav_bookmarks, R.id.nav_signup
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val sp = getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)
        val img = sp.getString(AppConstants.IMAGE, "-1")
        val username = sp.getString(AppConstants.NAME, "a")
        val login = sp.getBoolean(AppConstants.ISLOGIN, false)

        if (login) {
            if (username!!.isEmpty()) {
                //Toast.makeText(applicationContext, "not user", Toast.LENGTH_LONG).show()

            } else {
            //    Toast.makeText(applicationContext, "$username, $login, $img", Toast.LENGTH_LONG)
              //      .show()
                val header = nav_view.getHeaderView(0)
                header.tv_username.text = username
                header.profilePhoto.setImageURI(Uri.parse(img))
              //  holder.img.setImageURI(Uri.parse(data[position].img))

            }

            hideItem()
        } else {
            showItem()
            Toast.makeText(applicationContext, "not login", Toast.LENGTH_LONG).show()
        }

        nav_view.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.nav_logout) {
                showItem()
                val sp = getSharedPreferences(AppConstants.SIGN_UP, Context.MODE_PRIVATE)
                val edit = sp.edit()
                edit.putBoolean(AppConstants.ISLOGIN, false)
                val d = edit.commit()
                if (d)
                    Toast.makeText(applicationContext, "logout Successfully", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(applicationContext, "logout failed", Toast.LENGTH_SHORT).show()
            }
            NavigationUI.onNavDestinationSelected(menuItem, navController)
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        })

        val data = intent
        if (data.getStringExtra(AppConstants.CART) == "cart") {
            Toast.makeText(applicationContext, "cart page", Toast.LENGTH_LONG).show()
            // val fragment=   supportFragmentManager.findFragmentById(R.id.nav_orders)
            /// navView.findFragment<Fragment>(fragment)
        }

    }

    private fun showItem() {
        val nav_menu: Menu = nav_view.menu

        nav_menu.findItem(R.id.nav_signup).setVisible(true)
        nav_menu.findItem(R.id.nav_logout).setVisible(false)

    }

    private fun hideItem() {

        val nav_menu: Menu = nav_view.menu
        nav_menu.findItem(R.id.nav_signup).setVisible(false)
        nav_menu.findItem(R.id.nav_logout).setVisible(true)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}

