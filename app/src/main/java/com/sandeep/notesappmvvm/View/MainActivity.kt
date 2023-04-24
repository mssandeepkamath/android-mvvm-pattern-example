package com.sandeep.notesappmvvm.View

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sandeep.notesappmvvm.Model.Data.Notes
import com.sandeep.notesappmvvm.Model.Data.NotesDatabase
import com.sandeep.notesappmvvm.Model.Repository.NotesRepository
import com.sandeep.notesappmvvm.ViewModel.MainViewModel
import com.sandeep.notesappmvvm.ViewModel.MainViewModelFactory
import com.sandeep.notesappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val notesDao = NotesDatabase.getDatabaseInstance(applicationContext).notesDao()
        val notesRepository = NotesRepository(notesDao)
        val mainViewModel =  ViewModelProvider(this, MainViewModelFactory(notesRepository)).get(
            MainViewModel::class.java)
        val adapter = NotesAdapter()
        activityMainBinding.rvnotes.adapter = adapter
        mainViewModel.listNotes().observe(this) {
           adapter.submitList(it)
        }

        activityMainBinding.btnAdd.setOnClickListener{
            if(activityMainBinding.edtNote.text!!.isEmpty()){
                Toast.makeText(this,"Please enter some note",Toast.LENGTH_SHORT).show()
            }
            else {
                mainViewModel.insertNote(Notes(0,activityMainBinding.edtNote.text.toString()))
                Toast.makeText(this,"DONE",Toast.LENGTH_SHORT).show()
                activityMainBinding.edtNote.text = null
            }
        }
    }

}