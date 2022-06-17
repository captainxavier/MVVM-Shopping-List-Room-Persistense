package com.xavier.shopping.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @ColumnInfo(name = "item_info")
    var name: String,
    @ColumnInfo(name = "item_price")
    var price: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}