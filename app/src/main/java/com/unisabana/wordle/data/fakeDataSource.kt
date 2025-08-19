package com.unisabana.wordle.data

val words = listOf<String>(
    "apple",
    "house",
    "music",
    "table",
    "chair",
    "plant",
    "water",
    "light",
    "stone",
    "paper",
    "glass",
    "bread",
    "cloud",
    "beach",
    "world"
)

fun getRandomWord():String{
    return words.random()
}