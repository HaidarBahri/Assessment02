package com.d3if0051.assessment02mobpro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d3if0051.assessment02mobpro.data.PertanyaanDao

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val dataSource: PertanyaanDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dataSource) as T
        }
        throw IllegalAccessException("Unable to construct ViewModel")
    }
}