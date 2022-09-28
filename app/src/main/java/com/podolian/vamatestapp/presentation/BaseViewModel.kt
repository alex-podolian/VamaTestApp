package com.podolian.vamatestapp.presentation

import androidx.lifecycle.ViewModel
import com.podolian.vamatestapp.utils.StateWrapper
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel<UiState>(initialState: UiState) : ViewModel() {

    protected val _uiState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val uiState: StateWrapper<UiState>
        get() = StateWrapper(_uiState)
}