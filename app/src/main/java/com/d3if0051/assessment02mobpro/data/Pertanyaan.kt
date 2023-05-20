package com.d3if0051.assessment02mobpro.data

import androidx.room.Entity
import com.google.firebase.database.Exclude

@Entity
data class Pertanyaan(
    @get:Exclude
    var id: String = "",
    var userId: String = "",
    var pertanyaan: String = "",
)