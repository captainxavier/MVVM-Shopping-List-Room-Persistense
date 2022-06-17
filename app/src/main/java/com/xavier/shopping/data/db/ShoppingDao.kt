package com.xavier.shopping.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.xavier.shopping.data.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertShoppingItem(item: ShoppingItem)
    @Delete
    suspend fun deleteShoppingItem(item: ShoppingItem)
    @Query(value="SELECT * FROM shopping_table")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}