package com.example.navigationtask.ui.secondFragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.navigationtask.infrastructure.model.Click
import com.example.navigationtask.infrastructure.repository.ClickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class secondViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    val repository = ClickRepository(application)

    private var _clicksList = MutableLiveData<List<Click>>()
    val clicksList: LiveData<List<Click>>
        get() = _clicksList

    init {
        viewModelScope.launch{
            getClicks()
        }
    }

    suspend fun getClicks(){
        _clicksList.value = repository.getClick().await()
    }
}