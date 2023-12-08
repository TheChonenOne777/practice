package com.example.practice.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _currentScreen = MutableStateFlow(List)
    val currentScreen = _currentScreen.asStateFlow()

    fun onCreate(isRestoring: Boolean) {
        if (!isRestoring) _currentScreen.value = List
    }
}
