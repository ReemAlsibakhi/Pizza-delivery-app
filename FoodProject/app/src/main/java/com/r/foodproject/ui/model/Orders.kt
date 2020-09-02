package com.r.foodproject.ui.model

import android.os.Parcel
import android.os.Parcelable

data class Orders(
    var id: Int,
    var product_id: Int,
    var user_id: Int,
    var name: String?,
    var img: Int,
    var price: Double
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble()

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(product_id)
        parcel.writeInt(user_id)
        parcel.writeString(name)
        parcel.writeInt(img)
        parcel.writeDouble(price)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Orders> {
        const val TABLE_NAME = "orders"
        const val COL_ID = "id"
        const val COL_PRODUCT_ID = "product_id"
        const val COL_USER_ID = "user_id"
        const val COL_NAME = "name"
        const val COL_IMG = "image"
        const val COL_PRICE = "price"
        const val CREATE_TABLE =
            "create table $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $COL_PRODUCT_ID INTEGER REFERENCES ${Product.TABLE_NAME}(${Product.COL_ID}) , " +
                    "$COL_USER_ID INTEGER REFERENCES ${Users.TABLE_NAME}(${Users.COL_ID}) ,$COL_NAME TEXT NOT NULL, $COL_IMG TEXT , $COL_PRICE DOUBLE )";

        override fun createFromParcel(parcel: Parcel): Orders {
            return Orders(parcel)
        }

        override fun newArray(size: Int): Array<Orders?> {
            return arrayOfNulls(size)
        }
    }


}
