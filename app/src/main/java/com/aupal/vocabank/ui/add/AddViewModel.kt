package com.aupal.vocabank.ui.add

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aupal.vocabank.data.Repository
import com.aupal.vocabank.data.VocabData
import com.aupal.vocabank.ui.state.UiState
import kotlinx.coroutines.launch

class AddViewModel(val repository: Repository): ViewModel() {

    private val _State = mutableStateOf<UiState<List<VocabData>>>(UiState.Loading)
    val vocabList: State<UiState<List<VocabData>>> = _State

    fun addVocab(vocabData: VocabData){
        viewModelScope.launch {
            try {
                repository.addVocab(vocabData)
            } catch (e: Exception) {
                _State.value = UiState.Error("Failed to add vocab")
            }
        }
    }
}