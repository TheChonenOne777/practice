package com.example.practice.main

import com.example.practice.features.list.ListFragment
import javax.inject.Inject

class Router @Inject constructor() {

    fun resolve(screen: Screen) = when (screen) {
        is List -> ListFragment()
    }
}

sealed interface Screen
data object List : Screen
