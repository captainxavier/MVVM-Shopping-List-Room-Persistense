package com.xavier.shopping.data.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xavier.shopping.data.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDataBase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        // Singleton prevents multiple
        // instances of database opening at the
        // same time.

        @Volatile
        private var INSTANCE: ShoppingDataBase? = null


        fun getDatabase(context: Context): ShoppingDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingDataBase::class.java,
                    "shopping_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}