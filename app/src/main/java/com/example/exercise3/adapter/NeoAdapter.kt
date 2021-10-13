package com.example.exercise3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise3.R
import com.example.exercise3.models.Neo
import kotlinx.android.synthetic.main.item_neo_index.view.*
import kotlinx.android.synthetic.main.layout_button_load_more.view.*

class NeoAdapter(
    val c: Context,
    var neoList: List<Neo>,
) :
    RecyclerView.Adapter<NeoAdapter.NeoViewHolder>() {

    val VIEW_TYPE_FOOTER = R.layout.layout_button_load_more
    val VIEW_TYPE_CELL = R.layout.item_neo_index

    inner class NeoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NeoAdapter.NeoViewHolder {
        return when (viewType) {
            VIEW_TYPE_CELL -> NeoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_neo_index, parent, false
                )
            )
            else -> NeoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_button_load_more, parent, false
                )
            )
        }
    }

    private var onItemClickListener: ((Neo) -> Unit)? = null

    private var onButtonLoadMoreClickListener: IOnButtonLoadMoreClick? = null

    fun setOnButtonLoadMoreClickListener(listener: IOnButtonLoadMoreClick) {
        onButtonLoadMoreClickListener = listener
    }

    fun setOnItemClickListener(listener: (Neo) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == neoList.size)
            VIEW_TYPE_FOOTER
        else VIEW_TYPE_CELL
    }

    override fun onBindViewHolder(holder: NeoAdapter.NeoViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_FOOTER) {
            holder.itemView.apply {
               btnLoadMore.setOnClickListener {
                   onButtonLoadMoreClickListener?.onButtonClick()
               }
            }
        } else {
            val neo = neoList[position]
            holder.itemView.apply {
                val index = neo.index ?: ""
                tvNameIndex.text = neo.name + " " + index
                tvAddress.text = neo.address
                setOnClickListener {
                    onItemClickListener?.let {
                        it(neo)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return (neoList.size + 1)
    }

    interface IOnButtonLoadMoreClick {
        fun onButtonClick()
    }
}