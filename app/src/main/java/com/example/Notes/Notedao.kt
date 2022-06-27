package com.example.Notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Notedao {

    @Query("SELECT * FROM note_table ORDER BY note_text ASC")
    fun getNotes(): LiveData<List<Notes>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: Notes)

    @Delete
    suspend fun delete(notes: Notes)
}