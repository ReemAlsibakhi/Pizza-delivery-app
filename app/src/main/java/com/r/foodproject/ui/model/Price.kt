package com.r.foodproject.ui.model

import android.os.Parcel
import android.os.Parcelable

data class Price(var price:Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Price> {
        const val TABLE_NAME = "price"
        const val COL_ID = "id"
        const val COL_PRICE = "pri"

        const val CREATE_TABLE =
            "create table $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COL_PRICE DOUBLE)";

        override fun createFromParcel(parcel: Parcel): Price {
            return Price(parcel)
        }

        override fun newArray(size: Int): Array<Price?> {
            return arrayOfNulls(size)
        }
    }
}