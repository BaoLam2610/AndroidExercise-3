package com.example.exercise3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise3.R
import com.example.exercise3.models.Neo
import com.example.exercise3.models.New
import com.example.exercise3.ui.main.fragments.ArticleFragmentDirections
import com.example.exercise3.ui.main.fragments.NewsFragmentDirections
import kotlinx.android.synthetic.main.item_new.view.*

class NewAdapter(
    val c: Context,
    val newList: List<New>,
) : RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    private val VIEW_BANNER = 0
    private val VIEW_ITEM = 1

    inner class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAdapter.NewViewHolder {
        return when (viewType) {
            VIEW_BANNER -> NewViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_new_banner, parent, false
                )
            )
            else -> NewViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_new, parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: NewAdapter.NewViewHolder, position: Int) {
        if (position == 0) {
            holder.itemView.apply {
                setOnClickListener {
                    val action = NewsFragmentDirections.actionNewsFragmentToArticleFragment(null)
                    findNavController().navigate(action)
                }
            }
        } else {
            val new = newList[position - 1]
            holder.itemView.apply {
                ivLogo.setImageResource(new.logo)
                tvDate.text = new.date
                tvName.text = new.name
                tvIndex.text = new.index
                ivNotification.visibility = if (new.notification) View.VISIBLE else View.GONE

                setOnClickListener {
                    onItemClickListener?.let {
                        it(new)
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0)
            VIEW_BANNER
        else VIEW_ITEM
    }

    override fun getItemCount(): Int = newList.size + 1

    private var onItemClickListener: ((New) -> Unit)? = null

    fun setOnItemClickListener(listener: (New) -> Unit) {
        onItemClickListener = listener
    }
}