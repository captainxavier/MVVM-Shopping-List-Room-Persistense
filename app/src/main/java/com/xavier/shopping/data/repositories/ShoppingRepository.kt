package com.xavier.shopping.data.repositories

import androidx.lifecycle.LiveData
import com.xavier.shopping.data.db.ShoppingDao
import com.xavier.shopping.data.db.ShoppingDataBase
import com.xavier.shopping.data.entities.ShoppingItem

class ShoppingRepository(
    private val shoppingDao: ShoppingDao){

    val allShoppingItem:LiveData<List<ShoppingItem>> = shoppingDao.getAllShoppingItems()


    suspend fun insetItem(item: ShoppingItem){
        shoppingDao.insertShoppingItem(item)
    }


    suspend fun deleteItem(item: ShoppingItem){
        shoppingDao.deleteShoppingItem(item)
    }
}