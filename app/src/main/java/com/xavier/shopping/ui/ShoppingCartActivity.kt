package com.xavier.shopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xavier.shopping.R

class ShoppingCartActivity : AppCompatActivity() {
    
    private val TAG = "ShoppingCartActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        Log.d(TAG, "onCreate: started::")
    }
}