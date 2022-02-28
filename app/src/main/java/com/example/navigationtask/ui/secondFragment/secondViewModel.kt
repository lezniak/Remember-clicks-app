package com.example.navigationtask.ui.secondFragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationtask.infrastructure.model.Click
import com.example.navigationtask.infrastructure.repository.ClickRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class secondViewModel(application: Application) : AndroidViewModel(application) {
    val repository = ClickRepository(application)
    lateinit var clickList : List<Click>

    init {
        viewModelScope.launch{
            getClicks()
            Log.d("ELO",clickList.toString())
        }
    }

    suspend fun getClicks(){
        clickList = repository.getClick().await()
    }
}