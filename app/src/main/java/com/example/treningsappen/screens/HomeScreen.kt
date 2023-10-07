package com.example.treningsappen.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.treningsappen.R.layout.fragment_home_screen

class HomeScreen {

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fragment_home_screen, container, false)
    }

    fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}


