package com.example.navigationtask.infrastructure.database

import androidx.room.*
import com.example.navigationtask.infrastructure.model.Click
@Dao
interface databaseDAO {
    @Insert
    fun insert(click: Click)

    @Update
    fun update(click: Click)

    @Delete
    fun delete(click: Click)

    @Query("Select * from click_table")
    fun getAll(): List<Click>

    @Query("delete from click_table")
    fun deleteAllNotes()

}