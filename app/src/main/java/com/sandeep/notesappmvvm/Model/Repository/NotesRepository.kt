package com.sandeep.notesappmvvm.Model.Repository

import androidx.lifecycle.LiveData
import com.sandeep.notesappmvvm.Model.Data.Notes
import com.sandeep.notesappmvvm.Model.Dao.NotesDao

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun insertNote(notes: Notes) {
        notesDao.insertNote(notes)
    }

     fun getNotes() : LiveData<List<Notes>> {
        return notesDao.getNotes()
    }
}