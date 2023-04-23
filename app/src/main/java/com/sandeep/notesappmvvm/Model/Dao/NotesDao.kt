package com.sandeep.notesappmvvm.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sandeep.notesappmvvm.Model.Data.Notes

@Dao
interface NotesDao {

    @Insert
    suspend fun insertNote(notes : Notes)


    @Delete
    suspend fun deleteNote(notes: Notes)

    @Query(value = "SELECT * FROM notes")
    fun getNotes(): LiveData<List<Notes>>


}