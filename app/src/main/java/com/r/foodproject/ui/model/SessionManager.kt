package com.r.foodproject.ui.model

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.util.Log


class SessionManager(context: Context) {
    // shared preferences
    var preferences: SharedPreferences
    var editor: Editor
    var context: Context
    //shared pref mode
    var PRIVATE_MODE = 0

    companion object {
        private val TAG = SessionManager::class.java.simpleName
        // shared preferences file name
        private const val PREFS_NAME = "loginUser"
        private const val KEY_IS_LOGGEDINUser = "isLoggedInUser"
    }

    //consructor
    init {
        this.context = context
        preferences =
            context.getSharedPreferences(PREFS_NAME, PRIVATE_MODE)
        editor = preferences.edit()
    }
    fun setLoginUser(isLoggedIn: Boolean) {
        editor.putBoolean(KEY_IS_LOGGEDINUser, isLoggedIn)
        editor.commit()
        Log.d(TAG, "User login session modified!")
    }

    fun logOutUser() {
        val settings: SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, 0)
        editor = settings.edit()
        editor.remove(KEY_IS_LOGGEDINUser)
        editor.commit()
    }




    /**
     * public void checkLogin(boolean isLoggedIn){
     * editor.putBoolean(KEY_IS_LOGGEDIN,isLoggedIn);
     * editor.commit();
     * //commit the changes
     * Log.d(TAG,"User login session modified!");
     * }
     */
//    fun isLoggedInUser(): Boolean {
//        return preferences.getBoolean(KEY_IS_LOGGEDINUser, false)
//    }
//
//    fun isLoggedInCompany(): Boolean {
//        return preferences.getBoolean(KEY_IS_LOGGEDINCompany, false)
//    }


}