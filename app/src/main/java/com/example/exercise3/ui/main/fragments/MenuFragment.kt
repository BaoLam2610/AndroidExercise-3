package com.example.exercise3.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise3.R
import com.example.exercise3.adapter.MenuAdapter
import com.example.exercise3.adapter.PersonalMenuAdapter
import com.example.exercise3.models.Menu
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var personMenuAdapter: PersonalMenuAdapter
    private lateinit var toolMenuAdapter: MenuAdapter
    private lateinit var marketMenuAdapter: MenuAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        personMenuAdapter = PersonalMenuAdapter(requireContext(), personMenuList)
        toolMenuAdapter = MenuAdapter("Tools", toolMenuList)
        marketMenuAdapter = MenuAdapter("Markets", marketMenuList)

        rvMenu.layoutManager = LinearLayoutManager(requireContext())
        val concatAdapter = ConcatAdapter(personMenuAdapter, toolMenuAdapter, marketMenuAdapter)
        rvMenu.adapter = concatAdapter

        btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_homeFragment)
        }

        btnNew.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_newsFragment)
        }

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    var personMenuList = mutableListOf(
        Menu("Alerts", R.drawable.icons_8_alarm),
        Menu("Predictions", R.drawable.icons_8_left_and_right_arrows),
        Menu("Saved elements", R.drawable.icons_8_pin),
        Menu("Remove Ads", R.drawable.icons_8_no_entry),
    )

    var toolMenuList = mutableListOf(
        Menu("Select Stocks", R.drawable.icons_8_profit_2),
        Menu("Currency Exchange", R.drawable.icons_8_swap),
        Menu("Webinar", R.drawable.icons_8_video_call),
        Menu("Best Broker", R.drawable.icons_8_rent),
    )

    var marketMenuList = mutableListOf(
        Menu("Select Stocks", R.drawable.icons_8_profit_2),
        Menu("Currency Exchange", R.drawable.icons_8_swap),
        Menu("Webinar", R.drawable.icons_8_video_call),
        Menu("Best Broker", R.drawable.icons_8_rent),
    )
}