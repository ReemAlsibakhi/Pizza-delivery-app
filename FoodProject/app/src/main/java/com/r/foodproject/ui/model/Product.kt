package com.r.foodproject.ui.model

import android.os.Parcel
import android.os.Parcelable

data class Product(
    var id: Int,
    var name: String?,
    var description: String,
    var img: Int,
    var pro_amount: Int,
    var price: Double,
    var is_fav: Int,
    var rate: Int,
    var id_categ: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()

    )override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(img)
        parcel.writeInt(pro_amount)
        parcel.writeDouble(price)
        parcel.writeInt(is_fav)
        parcel.writeInt(rate)
        parcel.writeInt(id_categ)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        const val TABLE_NAME = "product"

        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_DESC = "description"
        const val COL_IMG = "image"
        const val COL_AMOUNT = "productAmout"
        const val COL_PRICE = "price"
        const val COL_ISFAV = "isFav"
        const val COL_RATE = "rate"
        const val COL_ID_CATEGORIES = "id_categ"

        const val CREATE_TABLE =
            "create table $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COL_NAME TEXT NOT NULL, $COL_DESC TEXT NOT NULL, $COL_IMG TEXT  , " +
                    "$COL_AMOUNT INTEGER, $COL_PRICE DOUBLE, " +
                    "$COL_ISFAV INTEGER , $COL_RATE INTEGER ,"+
                    " $COL_ID_CATEGORIES INTEGER REFERENCES ${Categories.TABLE_NAME}(${Categories.COL_ID}) )";

        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }


}
