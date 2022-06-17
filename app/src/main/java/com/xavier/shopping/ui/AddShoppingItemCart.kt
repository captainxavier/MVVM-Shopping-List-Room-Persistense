package com.xavier.shopping.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.xavier.shopping.R
import com.xavier.shopping.data.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*


class AddShoppingItemCart(context:Context,var addDialogListener: AddDialogListener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        tvAdd.setOnClickListener{
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all the information!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener{
            cancel()
        }
    }
}