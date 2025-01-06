package com.aupal.vocabank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aupal.vocabank.data.Repository
import com.aupal.vocabank.ui.add.AddViewModel
import com.aupal.vocabank.ui.list.ListViewModel

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {
                return AddViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                return ListViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel Class: " + modelClass.name)
        }
    }
}