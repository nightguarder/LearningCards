package com.example.learningcards.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.learningcards.data.local.User
import androidx.room.RoomDatabase


//Create main app Database
//Default Room Db code **DON'T MODIFY**

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        /*The value of a volatile variable will never be cached, and all writes and reads will be done to and from the main memory.
       This helps make sure the value of INSTANCE is always up-to-date and the same for all execution threads.
       It means that changes made by one thread to INSTANCE are visible to all other threads immediately.*/
        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                //If the database is not created
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "users"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
