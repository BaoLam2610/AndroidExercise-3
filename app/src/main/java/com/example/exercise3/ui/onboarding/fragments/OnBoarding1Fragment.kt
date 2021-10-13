package com.example.exercise3.ui.onboarding.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exercise3.R
import com.example.exercise3.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_1.*


class OnBoarding1Fragment : Fragment(R.layout.fragment_on_boarding_1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding1Fragment_to_onBoarding2Fragment)
        }
        tvSkip.setOnClickListener {

            Intent(requireContext(), LoginActivity::class.java).also{
                startActivity(it)

            }
        }
    }
}