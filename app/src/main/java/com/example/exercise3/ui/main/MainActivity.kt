package com.example.exercise3.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.exercise3.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        val backStackEntryCount = fragment?.childFragmentManager?.backStackEntryCount
        backStackEntryCount?.let {
            if (backStackEntryCount > 0)
                super.onBackPressed()
            else {
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Notification")
                    .setMessage("Do you want to exit from the application?")
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Yes") { _, _ ->
                        finishAffinity()
                    }
                    .create()
                dialog.show()
            }
        }
    }
}