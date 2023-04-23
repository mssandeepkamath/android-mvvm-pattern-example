package com.sandeep.notesappmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandeep.notesappmvvm.Model.Data.Notes
import com.sandeep.notesappmvvm.Model.Repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val notesRepository: NotesRepository) : ViewModel() {


    fun listNotes(): LiveData<List<Notes>> {
        return notesRepository.getNotes()
    }

    fun insertNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.insertNote(notes)
        }
    }

}