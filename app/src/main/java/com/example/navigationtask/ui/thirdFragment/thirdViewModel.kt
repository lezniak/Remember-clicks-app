package com.example.navigationtask.ui.thirdFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationtask.infrastructure.repository.ClickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class thirdViewModel @Inject constructor(application: Application): AndroidViewModel(application) {
    val repository = ClickRepository(application)

    fun clearClicks(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteClicks()
        }
    }
}