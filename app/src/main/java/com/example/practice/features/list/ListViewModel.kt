package com.example.practice.features.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.base.ResultModel
import com.example.practice.entity.MockItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val interactor: ListInteractor) : ViewModel() {

    private val _listItems = MutableStateFlow(listOf<MockItem>())
    val listItems = _listItems.asStateFlow()

    init {
        viewModelScope.launch {
            when (val result = interactor.getListOfItems()) {
                is ResultModel.Success -> _listItems.value = result.data
                is ResultModel.Error -> {} // show error
                // TODO: add loading state
            }
        }
    }

}
