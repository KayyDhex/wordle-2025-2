package com.unisabana.wordle.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unisabana.wordle.data.ScoreRepository
import com.unisabana.wordle.data.getRandomWord
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameViewModel(
    private val scoreRepository: ScoreRepository
): ViewModel() {

    // attributes
    var solution by mutableStateOf(getRandomWord())
        private set
    var currentWord by mutableStateOf("")
        private set
    var attempts by mutableStateOf(listOf<String>())
        private  set

    // func
    fun onKeyPressed(letter:Char){
        if(currentWord.length < 5){
            currentWord += letter
        }
    }
    fun onRemoveLetter(){
        if(!currentWord.isEmpty()){
            currentWord.dropLast(1)
        }
    }

     fun onSubmit(){

        // To check the word

        if(currentWord.length == 5){
            attempts = attempts + currentWord
            currentWord = ""
        }
    }

    fun saveGameResult(name:String){
        viewModelScope.launch {
            scoreRepository.saveScore(name,  0, solution, attempts)
        }
    }

    fun getAll(){

    }

    fun resetGame(){
        attempts = emptyList()
        solution = getRandomWord()
        currentWord = ""
    }
}