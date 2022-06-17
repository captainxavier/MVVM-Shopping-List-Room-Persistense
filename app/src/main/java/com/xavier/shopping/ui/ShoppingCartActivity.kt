package com.xavier.shopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xavier.shopping.R
import com.xavier.shopping.adapter.ShoppingItemAdapter
import com.xavier.shopping.data.db.ShoppingDataBase
import com.xavier.shopping.data.entities.ShoppingItem
import com.xavier.shopping.data.repositories.ShoppingRepository
import com.xavier.shopping.view_model.ShoppingViewModel
import kotlinx.android.synthetic.main.activity_shopping_cart.*
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class ShoppingCartActivity : AppCompatActivity(), ShoppingItemAdapter.ShoppingDeleteInterface,ShoppingItemAdapter.AddShoppingClickedInterface,ShoppingItemAdapter.SubtractShoppingClickedInterface{

    private val TAG = ShoppingCartActivity::class.simpleName

    lateinit var viewModel: ShoppingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        Log.d(TAG, "onCreate: started::")
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(this, this,this,this)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.allShoppingItem.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                adapter.updateList(it)
            }
        })


        fab.setOnClickListener{
            AddShoppingItemCart(this, object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.addShoppingItem(item)
                }
            }).show()
        }
    }

    override fun onDeleteIconClick(item: ShoppingItem) {
        // in click method we are calling delete
        // method from our view modal to delete our not.
        viewModel.deleteShopping(item)
        // displaying a toast message
        Toast.makeText(this, "${item.name} Deleted", Toast.LENGTH_LONG).show()
    }

    override fun onAddItemClick(item: ShoppingItem) {
        viewModel.addShoppingItem(item)
    }

    override fun onSubtractItemClick(item: ShoppingItem) {
        viewModel.addShoppingItem(item)
    }


}