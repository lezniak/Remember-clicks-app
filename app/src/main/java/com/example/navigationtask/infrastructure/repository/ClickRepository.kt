package com.example.navigationtask.infrastructure.repository

import android.app.Application
import com.example.navigationtask.infrastructure.database.DatabaseClick
import com.example.navigationtask.infrastructure.database.databaseDAO
import com.example.navigationtask.infrastructure.model.Click
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class ClickRepository(application: Application) {
    private var database  = DatabaseClick.getInstance(application)
    private lateinit var databaseDAO: databaseDAO

    init {
        databaseDAO = database.clickDao()
    }

    fun addClick(click: Click){
        databaseDAO.insert(click)
    }

    fun getClick(): Deferred<List<Click>>{
        return CoroutineScope(Dispatchers.IO).async{
            databaseDAO.getAll()
        }

    }
}