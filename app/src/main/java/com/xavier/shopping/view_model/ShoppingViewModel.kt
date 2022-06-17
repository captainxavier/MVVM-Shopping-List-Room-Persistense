package com.xavier.shopping.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xavier.shopping.data.db.ShoppingDao
import com.xavier.shopping.data.db.ShoppingDataBase
import com.xavier.shopping.data.entities.ShoppingItem
import com.xavier.shopping.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application):AndroidViewModel(application) {

       val allShoppingItem: LiveData<List<ShoppingItem>>
       val repository:ShoppingRepository

    init {
        val dao = ShoppingDataBase.getDatabase(application).getShoppingDao()
        repository = ShoppingRepository(dao)
        allShoppingItem = repository.allShoppingItem
    }

    // on below line we are creating a new method for deleting a note. In this we are
    // calling a delete method from our repository to delete our note.
    fun deleteShopping (item: ShoppingItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteItem(item)
    }


    // on below line we are creating a new method for adding a new note to our database
    // we are calling a method from our repository to add a new note.
    fun addShoppingItem(item: ShoppingItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.insetItem(item)
    }

}