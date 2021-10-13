package com.example.exercise3.ui.login.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exercise3.R
import kotlinx.android.synthetic.main.fragment_email.*
import kotlinx.coroutines.*

class EmailFragment : Fragment(R.layout.fragment_email) {
    private val TAG = "EmailFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var second = 5
        runBlocking {

            GlobalScope.launch(Dispatchers.Main) {
                btnResendEmail?.isClickable = false
                Toast.makeText(requireContext(), "Confirm password changed", Toast.LENGTH_SHORT)
                while (second <= 5) {
                    second--
                    delay(1000)
                    tvSecond?.text = "Wait $second seconds before sending it"
                    if (second == 0)
                        break
                }
                btnResendEmail?.isClickable = true
            }
        }
        btnResendEmail.setOnClickListener {
            findNavController().navigate(R.id.action_emailFragment_to_confirmPasswordFragment)
        }

    }


}