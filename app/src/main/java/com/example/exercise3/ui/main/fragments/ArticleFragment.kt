package com.example.exercise3.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exercise3.R
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val args by navArgs<ArticleFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.new?.let {
            tvTitle.text = args.new?.name
        }

        btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_articleFragment_to_homeFragment)
        }

        btnPersonal.setOnClickListener {
            findNavController().navigate(R.id.action_articleFragment_to_menuFragment)
        }

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}