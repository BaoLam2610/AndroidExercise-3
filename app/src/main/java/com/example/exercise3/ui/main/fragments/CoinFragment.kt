package com.example.exercise3.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exercise3.R
import kotlinx.android.synthetic.main.fragment_coin.*

class CoinFragment : Fragment(R.layout.fragment_coin) {

    private val args by navArgs<CoinFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = args.neo.index ?: ""
        tvNeoIndex.text = args.neo.name + " " + index

        var check = false
        btnNotification.setOnClickListener {
            check = if (!check) {
                it.setBackgroundResource(R.drawable.custom_btn_notification_home_1)
                true
            } else {
                it.setBackgroundResource(R.drawable.custom_btn_notification_home)
                false
            }
        }

        btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_coinFragment_to_homeFragment)
        }

        btnNew.setOnClickListener {
            findNavController().navigate(R.id.action_coinFragment_to_newsFragment)
        }

        btnPersonal.setOnClickListener {
            findNavController().navigate(R.id.action_coinFragment_to_menuFragment)
        }

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}