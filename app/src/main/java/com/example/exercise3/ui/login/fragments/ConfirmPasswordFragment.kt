package com.example.exercise3.ui.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.exercise3.R
import com.example.exercise3.models.User
import kotlinx.android.synthetic.main.fragment_confirm_password.*


class ConfirmPasswordFragment : Fragment(R.layout.fragment_confirm_password) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            val user = User("", "123")
            val action = ConfirmPasswordFragmentDirections.actionConfirmPasswordFragmentToLoginFragment(user)
            findNavController().navigate(action)
        }
    }
}