package com.mobile.test.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.test.R
import com.mobile.test.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        supportFragmentManager.findFragmentById(R.id.mainContainer)?.childFragmentManager?.popBackStack()
    }
}