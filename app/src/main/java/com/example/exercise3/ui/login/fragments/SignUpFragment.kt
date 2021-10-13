package com.example.exercise3.ui.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.exercise3.R
import com.example.exercise3.models.User
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_emailFragment)
        }

        tvLogin.setOnClickListener {
            val user = User("","")
            val action = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment(user)
            findNavController().navigate(action)
        }

        btnSignUp.setOnClickListener {
            val user = User(etEmail.text.toString(), etPassword.text.toString())
            val action = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment(user)
            findNavController().navigate(action)
        }
    }
}