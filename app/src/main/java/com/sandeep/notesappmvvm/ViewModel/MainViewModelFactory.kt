package com.sandeep.notesappmvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sandeep.notesappmvvm.Model.Repository.NotesRepository

class MainViewModelFactory(private val notesRepository: NotesRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(notesRepository) as T
    }
}