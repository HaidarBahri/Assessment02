package com.d3if0051.assessment02mobpro.viewModels

import androidx.lifecycle.ViewModel
import com.d3if0051.assessment02mobpro.livedata.FirebaseUserLiveData

class FirebaseUserViewModel: ViewModel() {
    val authState = FirebaseUserLiveData()
}