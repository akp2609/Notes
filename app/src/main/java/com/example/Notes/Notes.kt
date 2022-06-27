package com.example.Notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class Notes(@ColumnInfo(name = "note_text") val text: String?) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}