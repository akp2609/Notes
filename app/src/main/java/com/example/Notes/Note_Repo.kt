package com.example.Notes

import android.util.Log
import androidx.lifecycle.LiveData

class Note_Repo(private val notedao: Notedao) {

    //val getallnotes: LiveData<List<Notes>> = notedao.getNotes()

    fun getallnotes(): LiveData<List<Notes>> {
        val data = notedao.getNotes()
        Log.i("TAG","${data.value.toString()}")
        return data}

    suspend fun insert(notes: Notes){
       val data = notedao.insert(notes)
        Log.i("TAGDATA","${data}")
    }

    suspend fun delete(notes: Notes){
        notedao.delete(notes)
    }


}