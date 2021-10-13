package com.example.exercise3.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise3.R
import com.example.exercise3.adapter.NeoAdapter
import com.example.exercise3.models.Neo
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var adapter: NeoAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        btnNew.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newsFragment)
        }

        btnPersonal.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
        }
    }

    private fun initUI() {
        adapter = NeoAdapter(requireContext(), neoList)
        rvNeo.adapter = adapter
        rvNeo.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCoinFragment(it)
            findNavController().navigate(action)
        }
        adapter.setOnButtonLoadMoreClickListener(
            object : NeoAdapter.IOnButtonLoadMoreClick {
                override fun onButtonClick() {
                    loadMoreItem()
                    adapter.notifyDataSetChanged()
                }
            }
        )
        val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                neoList.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        }
        ItemTouchHelper(itemTouchHelperCallBack).apply {
            attachToRecyclerView(rvNeo)
        }

        var check = false

        btnNotification.setOnClickListener {
            check = if(!check) {
                it.setBackgroundResource(R.drawable.custom_btn_notification_home_1)
                true
            } else{
                it.setBackgroundResource(R.drawable.custom_btn_notification_home)
                false
            }
        }
    }

    var neoList = mutableListOf(
        Neo("DOWN JONES", null, "NYSE"),
        Neo("FTSE", 100, "LONDON"),
        Neo("IBEX", 35, "MADRID"),
        Neo("DAX", null, "XETRA"),
        Neo("DOWN JONES", null, "NYSE"),
        Neo("FTSE", 100, "LONDON"),
        Neo("IBEX", 35, "MADRID"),
        Neo("DAX", null, "XETRA")
    )
    var i = 0
    private fun loadMoreItem() {
        for (id in 0 until 2) {
            neoList.add(Neo("DOWN JONES", ++i, "NYSE"))
            neoList.add(Neo("FTSE", ++i, "LONDON"))
            neoList.add(Neo("IBEX", ++i, "MADRID"))
            neoList.add(Neo("DAX", ++i, "XETRA"))
            neoList.add(Neo("DOWN JONES", ++i, "NYSE"))
        }
    }
}