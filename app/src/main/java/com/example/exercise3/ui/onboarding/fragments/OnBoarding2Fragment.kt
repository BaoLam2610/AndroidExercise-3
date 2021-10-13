package com.example.exercise3.ui.onboarding.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exercise3.R
import com.example.exercise3.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_on_boarding_2.*


class OnBoarding2Fragment : Fragment(R.layout.fragment_on_boarding_2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding2Fragment_to_onBoarding3Fragment)
        }
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        tvSkip.setOnClickListener {
            Intent(requireContext(), LoginActivity::class.java).also {
                startActivity(it)

            }
        }
    }
}