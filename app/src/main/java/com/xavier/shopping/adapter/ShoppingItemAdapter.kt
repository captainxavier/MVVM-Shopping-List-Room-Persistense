package com.xavier.shopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xavier.shopping.R
import com.xavier.shopping.data.entities.ShoppingItem
import com.xavier.shopping.view_model.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*


class ShoppingItemAdapter(
    val context: Context,
    private val itemClickDeleteInterface:ShoppingDeleteInterface,
    private val itemAddClickedInterface: AddShoppingClickedInterface,
    private val itemSubClickedInterface: SubtractShoppingClickedInterface

) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    private var items = ArrayList<ShoppingItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingList = items[position]
        holder.itemView.tvName.text = curShoppingList.name
        holder.itemView.tvAmount.text = "${curShoppingList.price}"

        holder.itemView.ivDelete.setOnClickListener{
            itemClickDeleteInterface.onDeleteIconClick(curShoppingList)
        }
        holder.itemView.ivPlus.setOnClickListener{
            curShoppingList.price++
            itemAddClickedInterface.onAddItemClick(curShoppingList)
        }
        holder.itemView.ivDelete.setOnClickListener{
            if (curShoppingList.price>0){
                curShoppingList.price--
                itemSubClickedInterface.onSubtractItemClick(curShoppingList)
            }
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }

    fun updateList(newList: List<ShoppingItem>) {
        // on below line we are clearing
        // our notes array list
        items.clear()
        // on below line we are adding a
        // new list to our all notes list.
        items.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ShoppingDeleteInterface {
        // creating a method for click
        // action on delete image view.
        fun onDeleteIconClick(item: ShoppingItem)
    }


    interface AddShoppingClickedInterface {
        // creating a method for click
        // action on delete image view.
        fun onAddItemClick(item: ShoppingItem)
    }

    interface SubtractShoppingClickedInterface {
        // creating a method for click
        // action on delete image view.
        fun onSubtractItemClick(item: ShoppingItem)
    }

}