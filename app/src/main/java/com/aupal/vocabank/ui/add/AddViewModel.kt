package com.aupal.vocabank.ui.add

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aupal.vocabank.data.Repository
import com.aupal.vocabank.data.VocabData
import com.aupal.vocabank.ui.state.DialogState
import com.aupal.vocabank.ui.state.UiState
import kotlinx.coroutines.launch

class AddViewModel(val repository: Repository): ViewModel() {

    private val _State = mutableStateOf<UiState<DialogState?>>(UiState.Empty)
    val state: State<UiState<DialogState?>> = _State

    private val _vocabState = mutableStateOf<UiState<List<VocabData>>>(UiState.Loading)
    val vocabState: State<UiState<List<VocabData>>> = _vocabState



    fun addVocab(vocabData: VocabData){
        _State.value = UiState.Loading
        viewModelScope.launch {
            try {
                _State.value = UiState.Empty
                repository.addVocab(vocabData)
            } catch (e: Exception) {
                _State.value = UiState.Error("Failed to add vocab")
            }
        }
    }

    fun checkVocab(vocab: String){
        _State.value = UiState.Loading
        viewModelScope.launch {
            try {
                val isExisting = repository.checkVocab(vocab)
                if (isExisting) {
                    _State.value = UiState.Success(DialogState.Existing)
                } else {
                    _State.value = UiState.Success(DialogState.Confirmation)
                }
            } catch (e: Exception) {
                _State.value = UiState.Error("Failed to check vocab")
            }

        }
    }

    fun dismissDialog(){
        _State.value = UiState.Empty
    }

}