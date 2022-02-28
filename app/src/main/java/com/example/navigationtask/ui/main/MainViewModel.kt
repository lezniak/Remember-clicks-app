package com.example.navigationtask.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationtask.infrastructure.database.DatabaseClick
import com.example.navigationtask.infrastructure.database.databaseDAO
import com.example.navigationtask.infrastructure.model.Click
import com.example.navigationtask.infrastructure.repository.ClickRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ClickRepository(application)


    fun addNewClick(click: Click){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addClick(click)
        }
    }
}