package com.mobile.test.presentation.listCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.test.domain.listCard.GetListCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCardViewModel @Inject constructor(private val useCase: GetListCard) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)

            useCase.run().fold({/*todo error*/ },
                { list -> _state.value = UiState(cards = list.toPresentation()) })

        }
    }
}