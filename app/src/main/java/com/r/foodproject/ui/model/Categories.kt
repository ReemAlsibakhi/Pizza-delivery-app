package com.r.foodproject.ui.model

import android.os.Parcel
import android.os.Parcelable

data class Categories(var id: Int, var title: String?) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Categories> {
            const val TABLE_NAME = "categories"
            const val COL_ID = "id"
            const val COL_NAME = "title"

            const val CREATE_TABLE =
                "create table $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "$COL_NAME TEXT NOT NULL)";

        override fun createFromParcel(parcel: Parcel): Categories {
            return Categories(parcel)
        }

        override fun newArray(size: Int): Array<Categories?> {
            return arrayOfNulls(size)
        }
    }

}
