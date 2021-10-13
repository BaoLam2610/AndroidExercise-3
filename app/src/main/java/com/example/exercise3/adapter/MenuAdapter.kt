package com.example.exercise3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise3.R
import com.example.exercise3.models.Menu
import kotlinx.android.synthetic.main.item_menu_1.view.*
import kotlinx.android.synthetic.main.layout_header_menu.view.*

class MenuAdapter(
    val type: String,
    var menuList: List<Menu>,
) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    val VIEW_TYPE_HEADER = R.layout.layout_header_menu
    val VIEW_TYPE_FOOTER = R.layout.layout_footer_line
    val VIEW_TYPE_CELL = R.layout.item_menu_2

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return when (viewType) {
            VIEW_TYPE_CELL -> MenuViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_menu_2, parent, false
                )
            )
            VIEW_TYPE_HEADER -> MenuViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_header_menu, parent, false
                )
            )
            else -> MenuViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_footer_line, parent, false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_HEADER
            menuList.size + 1 -> VIEW_TYPE_FOOTER
            else -> VIEW_TYPE_CELL
        }
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        when (getItemViewType(position)) {
            VIEW_TYPE_HEADER -> {
                holder.itemView.apply {
                    tvMainTilte.text = type
                }
            }
            VIEW_TYPE_FOOTER -> {
                holder.itemView.apply {

                }
            }
            VIEW_TYPE_CELL -> {
                val menu = menuList[position - 1]
                holder.itemView.apply {
                    ivLogo.setImageResource(menu.logo)
                    tvTitle.text = menu.title
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return (menuList.size + 2)
    }

}