package com.example.lightsout


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import com.example.lightsout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //putting binding on mainActivity and adding fragments on activity_main.xml
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    }

}
