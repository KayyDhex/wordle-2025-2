package com.unisabana.wordle.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class ScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val name: String,
    val score: Int,
    val solution: String,
    val attempts: List<String>
)