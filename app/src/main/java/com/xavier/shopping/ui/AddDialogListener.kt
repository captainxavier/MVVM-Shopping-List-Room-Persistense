package com.xavier.shopping.ui

import com.xavier.shopping.data.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)
}