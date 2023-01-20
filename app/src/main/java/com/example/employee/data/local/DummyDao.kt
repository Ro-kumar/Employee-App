/*
 * *
 *  * Created by Prady on 11/07/22, 4:11 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/07/22, 10:15 AM
 *
 */

package com.example.employee.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DummyDao {

    /**
     * It returns a LiveData object of List of Dummy objects
     */
    @Query("SELECT * from tb_name")
    fun getDummy(): LiveData<List<Dummy>>

    @Insert
    suspend fun insertDummy(dummy: Dummy)
}