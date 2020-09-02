package com.r.foodproject.ui.model

import android.os.Parcel
import android.os.Parcelable

data class Users(var id: Int,var img:String, var userName: String?, var email :String , var password: String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(img)
        parcel.writeString(userName)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Users> {
            const val TABLE_NAME = "users"
            const val COL_ID = "id"
            const val COL_IMG = "img"
            const val COL_NAME = "name"
            const val COL_EMAIL = "email"
            const val COL_PASSWORD = "pswd"

            const val CREATE_TABLE =
                "create table $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "$COL_IMG TEXT ,$COL_NAME TEXT NOT NULL, $COL_EMAIL TEXT NOT NULL, $COL_PASSWORD  TEXT NOT NULL )";

        override fun createFromParcel(parcel: Parcel): Users {
            return Users(parcel)
        }

        override fun newArray(size: Int): Array<Users?> {
            return arrayOfNulls(size)
        }
    }


}
