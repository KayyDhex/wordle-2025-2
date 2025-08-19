package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unisabana.wordle.presentation.navigation.GameDestination
import com.unisabana.wordle.presentation.navigation.ScoreDestination

@Composable
fun HomeScreen(onPlay: () -> Unit, onLeaderBoard: () -> Unit) {
    Scaffold {
            innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ){
            Button({
                onPlay()
            }) {
                Text("Play!")
            }
            Button({
                onLeaderBoard()
            }) {
                Text("LeaderBoard!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen(
        onPlay = {},
        onLeaderBoard = {}
    )
}