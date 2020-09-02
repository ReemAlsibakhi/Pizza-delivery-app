package  com.r.foodproject.ui.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.r.foodproject.R
import com.r.foodproject.ui.model.Product.CREATOR.COL_AMOUNT
import com.r.foodproject.ui.model.Product.CREATOR.COL_DESC
import com.r.foodproject.ui.model.Product.CREATOR.COL_ID_CATEGORIES
import com.r.foodproject.ui.model.Product.CREATOR.COL_IMG
import com.r.foodproject.ui.model.Product.CREATOR.COL_ISFAV
import com.r.foodproject.ui.model.Product.CREATOR.COL_NAME
import com.r.foodproject.ui.model.Product.CREATOR.COL_PRICE
import com.r.foodproject.ui.model.Product.CREATOR.COL_RATE

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private var db: SQLiteDatabase

    init {
        db = writableDatabase
    }

    //called just one
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(Product.CREATE_TABLE)
        p0.execSQL(Categories.CREATE_TABLE)
        p0.execSQL(Users.CREATE_TABLE)
        p0.execSQL(Orders.CREATE_TABLE)

        p0.execSQL("INSERT INTO " + Categories.TABLE_NAME + "(${Categories.COL_NAME}) " + " Values ('Burger')")
        p0.execSQL("INSERT INTO " + Categories.TABLE_NAME + "(${Categories.COL_NAME}) " + " Values ('Pizza')")
        p0.execSQL("INSERT INTO " + Categories.TABLE_NAME + "(${Categories.COL_NAME}) " + " Values ('Dessert')")

        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Beef Burger with Beetroot'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','10','20.0', '0',' ${R.drawable.pizza}', '1', '0')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Beef Burger with Oozy Heeddar'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','5','15.8', '0', ' ${R.drawable.pizza}', '2', '0')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Beef Burger with Beetroot'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','10','20.0', '1', ' ${R.drawable.pizza}', '3', '0')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Beef Burger with Oozy Heeddar'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','5','15.8', '0', ' ${R.drawable.pizza}', '4', '0')"
        )


        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Pizza with Beetroot'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','10','20.0', '0',' ${R.drawable.pizza}', '1', '1')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Pizza with Oozy Heeddar'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','5','15.8', '0', ' ${R.drawable.pizza}', '2', '1')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Pizza with Beetroot'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','10','20.0', '0', ' ${R.drawable.pizza}', '3', '1')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Pizza with Oozy Heeddar'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','5','15.8', '0', ' ${R.drawable.pizza}', '4', '1')"
        )


        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Dessert with Beetroot'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','10','20.0', '0',' ${R.drawable.pizza}', '1', '2')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Dessert with Oozy Heeddar'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','5','15.8', '0', ' ${R.drawable.pizza}', '2', '2')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Dessert with Beetroot'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','10','20.0', '0', ' ${R.drawable.pizza}', '3', '2')"
        )
        p0.execSQL(
            "INSERT INTO " + Product.TABLE_NAME + "(${COL_NAME},${COL_DESC},${COL_AMOUNT}" +
                    ",${COL_PRICE},${COL_ISFAV},${COL_IMG},${COL_RATE},${COL_ID_CATEGORIES}) " + " Values ('Dessert with Oozy Heeddar'," +
                    "'A signature flame-grilled beef patty toppe with smoked bacon','5','15.8', '0', ' ${R.drawable.pizza}', '4', '2')"
        )


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS ${Product.TABLE_NAME}")
        p0!!.execSQL("DROP TABLE IF EXISTS ${Users.TABLE_NAME}")
        p0!!.execSQL("DROP TABLE IF EXISTS ${Categories.TABLE_NAME}")
        p0!!.execSQL("DROP TABLE IF EXISTS ${Orders.TABLE_NAME}")
        onCreate(p0)
    }
    //==================================================================

    fun addProduct(
        name: String,
        description: String,
        prodAmount: Int,
        price: Double,
        is_fav: Int,
        image: String,
        rate: Int,
        id_categ: Int
    ): Boolean {
        val cv = ContentValues()
        cv.put(Product.COL_NAME, name)
        cv.put(Product.COL_DESC, description)
        cv.put(Product.COL_AMOUNT, prodAmount)
        cv.put(Product.COL_PRICE, price)
        cv.put(Product.COL_ISFAV, is_fav)
        cv.put(Product.COL_IMG, image)
        cv.put(Product.COL_RATE, rate)
        cv.put(Product.COL_ID_CATEGORIES, id_categ)
        return db.insert(Product.TABLE_NAME, null, cv) > 0
    }

    fun save(id: Int): Boolean {
        val cv = ContentValues()
        cv.put(Product.COL_ISFAV, 1)
        Log.e("save", cv.toString())
        return db.update(Product.TABLE_NAME, cv, "id = $id", null) > 0
    }

    fun getFavourite(): ArrayList<Product> {

        val products = ArrayList<Product>()
        val c =
            db.rawQuery(
                "select * from ${Product.TABLE_NAME} WHERE ${Product.COL_ISFAV}=1  order by ${Product.COL_ID} DESC",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val prod = Product(
                c.getInt(0), c.getString(1), c.getString(2),
                c.getInt(3), c.getInt(4), c.getDouble(5), c.getInt(6), c.getInt(7), c.getInt(8)
            )
            products.add(prod)
            c.moveToNext()
        }
        c.close()
        return products
    }


    fun getBurger(): ArrayList<Product> {
        val products = ArrayList<Product>()
        val c =
            db.rawQuery(
                "select * from ${Product.TABLE_NAME} WHERE ${Product.COL_ID_CATEGORIES}=0  order by ${Product.COL_ID}   DESC",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val prod = Product(
                c.getInt(0), c.getString(1), c.getString(2),
                c.getInt(3), c.getInt(4), c.getDouble(5), c.getInt(6), c.getInt(7), c.getInt(8)
            )
            products.add(prod)
            c.moveToNext()
        }
        c.close()
        return products
    }

    fun getPizza(): ArrayList<Product> {
        val products = ArrayList<Product>()
        val c =
            db.rawQuery(
                "select * from ${Product.TABLE_NAME} WHERE ${Product.COL_ID_CATEGORIES}=1  order by ${Product.COL_ID}   DESC",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val prod = Product(
                c.getInt(0), c.getString(1), c.getString(2),
                c.getInt(3), c.getInt(4), c.getDouble(5), c.getInt(6), c.getInt(7), c.getInt(8)
            )
            products.add(prod)
            c.moveToNext()
        }
        c.close()
        return products
    }

    fun getDessert(): ArrayList<Product> {
        val products = ArrayList<Product>()
        val c =
            db.rawQuery(
                "select * from ${Product.TABLE_NAME} WHERE ${Product.COL_ID_CATEGORIES}=2  order by ${Product.COL_ID}   DESC",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val prod = Product(
                c.getInt(0), c.getString(1), c.getString(2),
                c.getInt(3), c.getInt(4), c.getDouble(5), c.getInt(6), c.getInt(7), c.getInt(8)
            )
            products.add(prod)
            c.moveToNext()
        }
        c.close()
        return products
    }

    fun deleteOrder(id: Int): Boolean {
         return db.delete(Orders.TABLE_NAME, "id = $id", null) > 0
        return true
    }

    fun updateProduct(oldId: Int, name: String, des: String): Boolean {
        val cv = ContentValues()
        cv.put(Product.COL_NAME, name)
        cv.put(Product.COL_DESC, des)
        return db.update(Product.TABLE_NAME, cv, "id = $oldId", null) > 0
    }

    /////////// categories
    fun addCategory(name: String): Boolean {
        val cv = ContentValues()
        cv.put(Categories.COL_NAME, name)
        return db.insert(Categories.TABLE_NAME, null, cv) > 0
    }
    /////////users

    fun addUser(image: String, name: String, email: String, password: String): Boolean {
        val cv = ContentValues()
        cv.put(Users.COL_IMG, image)
        cv.put(Users.COL_NAME, name)
        cv.put(Users.COL_EMAIL, email)
        cv.put(Users.COL_PASSWORD, password)
        return db.insert(Users.TABLE_NAME, null, cv) > 0
    }

    fun userAuth(email: String, password: String): Int {
        var i: Int = -1
        val selectionArgs = arrayOf<String>(email, password)
        val c =
            db.rawQuery(
                "select * from ${Users.TABLE_NAME} where ${Users.COL_EMAIL}=? and ${Users.COL_PASSWORD}=?",
                selectionArgs
            )
        c.moveToFirst()
        if (!c.isAfterLast) {
            i = c.getInt(0)
        }
        return if (i > 0) {
            i
        } else {
            -1
        }
    }

    /////////orders
    fun addOrder( id_prod: Int, user_id: Int, name:String ,image:String, price:Double): Boolean {
        val cv = ContentValues()
        cv.put(Orders.COL_PRODUCT_ID, id_prod)
        cv.put(Orders.COL_USER_ID, user_id)
        cv.put(Orders.COL_NAME, name)
        cv.put(Orders.COL_IMG, image)
        cv.put(Orders.COL_PRICE, price)
        return db.insert(Orders.TABLE_NAME, null, cv) > 0
    }

    fun getOrder(id_user:Int): ArrayList<Orders> {
        val order = ArrayList<Orders>()
        val c =
            db.rawQuery(
                "select * from ${Orders.TABLE_NAME} WHERE ${Orders.COL_USER_ID}=$id_user order by ${Orders.COL_ID}   DESC",
                null
            )
        c.moveToFirst()
        while (!c.isAfterLast) {
            val ord = Orders(
                c.getInt(0), c.getInt(1), c.getInt(2),c.getString(3),
                c.getInt(4),c.getDouble(5))
            order.add(ord)
            c.moveToNext()
        }
        c.close()
        return order
    }

    companion object {
        const val DATABASE_NAME = "FoodDB"
        const val DATABASE_VERSION = 2
    }


}