package com.d3if0051.assessment02mobpro.data

import androidx.lifecycle.LiveData
import androidx.room.Dao

@Dao
interface PertanyaanDao {
    //    @Insert
    fun insertData(pertanyaan: Pertanyaan)

    //    @Query("SELECT * FROM pertanyaan ORDER BY id")
    fun getData(): LiveData<List<Pertanyaan>>

    //    @Query("DELETE FROM pertanyaan WHERE id LIKE (:pertanyaanId)")
    fun deleteData(pertanyaanId: String)

//    @Query("UPDATE pertanyaan SET pertanyaan = (:pertanyaan) WHERE id LIKE (:pertanyaanId)")
//    fun updateData(pertanyaanId: Int, pertanyaan: String)

    //    @Update
    fun updateData(pertanyaan: Pertanyaan)
}