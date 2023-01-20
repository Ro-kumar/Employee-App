/*
 * *
 *  * Created by Prady on 11/07/22, 4:11 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/07/22, 10:15 AM
 *
 */

package com.example.employee.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/* The DummyDatabase class is a RoomDatabase that contains a single table, Dummy */
@Database(entities = [Dummy::class], version = 1)
abstract class DummyDatabase : RoomDatabase() {

    /**
     * It creates an instance of the DummyDatabase class
     */
    abstract fun dummyDao(): DummyDao

    /* A singleton pattern. */
    companion object {
        private var INSTANCE: DummyDatabase? = null
        fun getDatabase(context: Context): DummyDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        DummyDatabase::class.java,
                        "database_name"
                    )
//                      .createFromAsset("/assets/local.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}