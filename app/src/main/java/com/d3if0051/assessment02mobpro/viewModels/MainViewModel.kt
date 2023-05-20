package com.d3if0051.assessment02mobpro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if0051.assessment02mobpro.data.Pertanyaan
import com.d3if0051.assessment02mobpro.data.PertanyaanDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val db: PertanyaanDao) : ViewModel() {
    val data = db.getData()

    fun insertData(pertanyaan: Pertanyaan) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insertData(pertanyaan)
            }
        }
    }

    fun deleteData(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.deleteData(id)
            }
        }
    }

    fun updateData(pertanyaan: Pertanyaan) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.updateData(pertanyaan)
            }
        }
    }
}