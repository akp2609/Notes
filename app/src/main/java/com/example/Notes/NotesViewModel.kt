package com.example.Notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val allnotes: LiveData<List<Notes>>
   private val Repository: Note_Repo

    init {
        val Dao = NoteDatabase.getDatabase(application).NotesDao()
         Repository = Note_Repo(Dao)
        allnotes = Repository.getallnotes()
    }

    fun deletnode(notes: Notes) = viewModelScope.launch(Dispatchers.IO){
          Repository.delete(notes)
    }

    fun insertNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        Repository.insert(notes)
    }
}