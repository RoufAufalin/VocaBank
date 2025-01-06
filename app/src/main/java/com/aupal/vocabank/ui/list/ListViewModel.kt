package com.aupal.vocabank.ui.list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aupal.vocabank.data.Repository
import com.aupal.vocabank.data.VocabData
import com.aupal.vocabank.ui.state.UiState
import kotlinx.coroutines.launch


class ListViewModel (private val repository: Repository): ViewModel() {
    private val _vocabState = mutableStateOf<UiState<List<VocabData>>>(UiState.Loading)
    val vocabState: State<UiState<List<VocabData>>> = _vocabState

    fun getVocab(){
        _vocabState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val data = repository.getVocab()
                Log.d("ListViewModel", "getVocab: $data")
                _vocabState.value = UiState.Success(data)
            } catch (e: Exception) {
                _vocabState.value = UiState.Error("Failed to get vocab")
                Log.d("ListViewModel", "getVocab: ${e.message}")
            }
        }


    }
}