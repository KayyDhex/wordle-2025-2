package com.unisabana.wordle.presentation.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.unisabana.wordle.presentation.components.Grid
import com.unisabana.wordle.presentation.components.Keyboard


@Composable
fun GameScreen(navController: NavHostController, gameViewModel: GameViewModel = viewModel()){
    Scaffold {
            innerPadding ->
        Column (modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.Black)
        ){
            Grid(
                gameViewModel::solution.get(),
                gameViewModel::currentWord.get(),
                gameViewModel::attempts.get()
            )
            Keyboard(
                gameViewModel::onRemoveLetter,
                gameViewModel::onKeyPressed
            )
            Button(onClick = gameViewModel::onSubmit) {
                Text("Back")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen(){
    val navController = rememberNavController()
    GameScreen(navController)
}