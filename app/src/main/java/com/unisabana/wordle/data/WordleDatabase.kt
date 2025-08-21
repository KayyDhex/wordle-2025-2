package com.unisabana.wordle.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ScoreEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WordleDatabase : RoomDatabase() {

    abstract fun ScoreDao(): ScoreDao

    companion object{
        @Volatile private var INSTANCE: WordleDatabase? = null

        fun getDatabase(context: Context): WordleDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordleDatabase::class.java,
                    "database-wordle"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}