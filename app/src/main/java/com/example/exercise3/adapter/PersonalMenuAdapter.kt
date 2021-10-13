package com.example.exercise3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise3.R
import com.example.exercise3.models.Menu
import kotlinx.android.synthetic.main.item_menu_1.view.*

class PersonalMenuAdapter(
    val c: Context,
    var menuList: List<Menu>,
) :
    RecyclerView.Adapter<PersonalMenuAdapter.MenuViewHolder>() {

    val VIEW_TYPE_FOOTER = R.layout.layout_footer_line
    val VIEW_TYPE_CELL = R.layout.item_menu_1

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PersonalMenuAdapter.MenuViewHolder {
        return when (viewType) {
            VIEW_TYPE_CELL -> MenuViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_menu_1, parent, false
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
        return if (position == menuList.size)
            VIEW_TYPE_FOOTER
        else VIEW_TYPE_CELL
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_FOOTER) {
            holder.itemView.apply {

            }
        } else {
            val menu = menuList[position]

            holder.itemView.apply {
                ivLogo.setImageResource(menu.logo)
                tvTitle.text = menu.title
            }
        }
    }

    override fun getItemCount(): Int {
        return (menuList.size + 1)
    }

}