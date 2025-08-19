package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScoreScreen(onBack: () -> Unit) {
    Scaffold {
            innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ){
            Button({
                onBack()
            }) {
                Text("Return to home!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScoreScreen(){
    ScoreScreen (onBack={})
}