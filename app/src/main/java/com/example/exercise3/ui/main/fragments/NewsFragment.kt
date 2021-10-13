package com.example.exercise3.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise3.R
import com.example.exercise3.adapter.NewAdapter
import com.example.exercise3.models.New
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(R.layout.fragment_news) {

    lateinit var adapter: NewAdapter
    var newList = mutableListOf(
        New("ATLANTIA", "3 Sept 2020", "ALT -3,87%", R.drawable._390177, true),
        New("XIAOMI", "2 Sept 2020", "HKD -2,13%", R.drawable._351087, false),
        New("APPLE", "1 Sept 2020", "AAPL -0,91%", R.drawable._390206, false)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        adapter = NewAdapter(requireContext(), newList)
        rvNews.adapter = adapter
        rvNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter.setOnItemClickListener {
            val action = NewsFragmentDirections.actionNewsFragmentToArticleFragment(it)
            findNavController().navigate(action)
        }

        btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_homeFragment)
        }

        btnPersonal.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_menuFragment)
        }

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}