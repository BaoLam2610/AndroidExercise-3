package com.example.exercise3.ui.login.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exercise3.R
import com.example.exercise3.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val args: LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_emailFragment)
        }

        tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        btnLogin.setOnClickListener {
            Intent(requireContext(), MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
                activity?.finish()
            }
        }
        initUI()
    }

    private fun initUI() {
        args.let {
            etEmail.setText(args.user.email)
            etPassword.setText(args.user.password)
        }
    }
}