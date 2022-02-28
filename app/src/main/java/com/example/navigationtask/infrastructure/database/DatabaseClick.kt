package com.example.navigationtask.infrastructure.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.navigationtask.infrastructure.model.Click

@Database(entities = [Click::class], version = 1, exportSchema = false)
abstract class DatabaseClick: RoomDatabase() {
    abstract fun clickDao(): databaseDAO

    companion object{
        @Volatile
        private var INSTANCE: DatabaseClick? = null

        @Synchronized
        fun getInstance(context: Context): DatabaseClick{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseClick::class.java,
                        "database")
                        .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}
